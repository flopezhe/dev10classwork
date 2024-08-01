package learn.boardgames.domain;

import learn.boardgames.TestHelpers;
import learn.boardgames.data.BoardGameRepository;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BoardGameServiceTest {

    @Autowired
    BoardGameService service;

    @MockBean
    BoardGameRepository repository;

    @Test
    void shouldFindAll() {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        when(repository.findAll()).thenReturn(expected);

        List<BoardGame> actual = service.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByPlayerNumberTest2() {
        List<BoardGame> expected = List.of(TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT));

        when(repository.findByNumberOfPlayers(2)).thenReturn(expected);

        List<BoardGame> actual = service.findByNumberOfPlayers(2);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        BoardGame expected = TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM);

        when(repository.findById(anyInt())).thenReturn(expected);

        BoardGame actual = service.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddValidBoardGame() {
        BoardGame boardGame = TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);
        boardGame.setBoardGameId(0);

        BoardGame expectedGame = TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);

        when(repository.add(boardGame)).thenReturn(expectedGame);

        Result<BoardGame> actual = service.add(boardGame);

        assertTrue(actual.isSuccess());
        assertEquals(expectedGame, actual.getPayload());
    }

    @Test
    void shouldNotAddNullGame() {
        Result<BoardGame> actual = service.add(null);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithIdNot0() {
        BoardGame boardGame = TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("New game must not have id set.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithNoTitle() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setTitle(null);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game title is required.", actual.getMessages().get(0));

        boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setTitle(" ");

        actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game title is required.", actual.getMessages().get(0));

        boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setTitle("");

        actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game title is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithRatingUnder1() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setRating(0.9);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game rating must be 1-10.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithRatingOver10() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setRating(10.1);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game rating must be 1-10.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithMinPlayersUnder1() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMinimumPlayers(0);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Minimum players must be 1-100.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithMinPlayersOver100() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMinimumPlayers(101);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(2, actual.getMessages().size());
        assertEquals("Minimum players must be 1-100.", actual.getMessages().get(0));
        assertEquals("Maximum players must be more than minimum players.", actual.getMessages().get(1));
    }

    @Test
    void shouldNotAddGameWithMaxPlayersUnder1() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMaximumPlayers(0);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(2, actual.getMessages().size());
        assertEquals("Maximum players must be 1-100.", actual.getMessages().get(0));
        assertEquals("Maximum players must be more than minimum players.", actual.getMessages().get(1));
    }

    @Test
    void shouldNotAddGameWithMaxPlayersOver100() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMaximumPlayers(101);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Maximum players must be 1-100.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithMaxPlayersLessThanMinPlayers() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMaximumPlayers(1);
        boardGame.setMinimumPlayers(2);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Maximum players must be more than minimum players.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithNullWeight() {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setWeight(null);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Weight is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithDuplicateTitle() {
        BoardGame boardGame = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);
        boardGame.setBoardGameId(0);

        when(repository.findAll()).thenReturn(List.of(TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM)));

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game already exists, title: \"Test Title1\"", actual.getMessages().get(0));
    }

    @Test
    void shouldUpdateGame() {
        BoardGame boardGame = TestHelpers.makeExistingBoardGame();

        when(repository.update(boardGame)).thenReturn(true);

        Result<BoardGame> actual = service.update(boardGame);

        assertTrue(actual.isSuccess());
    }

    @Test
    void shouldNotUpdateMissingGame() {
        BoardGame game = TestHelpers.makeBoardGame(9, BoardGameWeight.HEAVY);

        Result<BoardGame> actual = service.update(game);

        assertFalse(actual.isSuccess());
        assertEquals(ResultType.NOT_FOUND, actual.getResultType());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game 9 not found.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateNullGame() {
        Result<BoardGame> actual = service.update(null);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateGameWith0Id() {
        BoardGame game = TestHelpers.makeNewBoardGame(BoardGameWeight.MEDIUM);
        game.setTitle("Not existing");

        Result<BoardGame> actual = service.update(game);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Existing game must not have id set.", actual.getMessages().get(0));
    }


    @Test
    void shouldDeleteByID() {

        when(repository.deleteById(1)).thenReturn(true);

        Result<Void> actual = service.deleteById(1);

        assertTrue(actual.isSuccess());
    }

    @Test
    void shouldNotDeleteMissingById() {
        Result<Void> actual = service.deleteById(1);

        assertFalse(actual.isSuccess());
        assertEquals(ResultType.NOT_FOUND, actual.getResultType());
    }
}