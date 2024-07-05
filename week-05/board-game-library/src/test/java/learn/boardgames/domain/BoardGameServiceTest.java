package learn.boardgames.domain;

import learn.boardgames.TestHelpers;
import learn.boardgames.data.BoardGameRepositoryDouble;
import learn.boardgames.data.DataAccessException;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameServiceTest {

    BoardGameService service = new BoardGameService(new BoardGameRepositoryDouble());

    @Test
    void shouldFindAll() throws DataAccessException {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        List<BoardGame> actual = service.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByPlayerNumberTest2() throws DataAccessException {
        List<BoardGame> expected = List.of(TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT));
        List<BoardGame> actual = service.findByNumberOfPlayers(2);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindById() throws DataAccessException {
        BoardGame expected = TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM);
        BoardGame actual = service.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddValidBoardGame() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);
        boardGame.setBoardGameId(0);

        BoardGame expectedGame = TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);

        Result<BoardGame> actual = service.add(boardGame);

        assertTrue(actual.isSuccess());
        assertEquals(expectedGame, actual.getPayload());
    }

    @Test
    void shouldNotAddNullGame() throws DataAccessException {
        Result<BoardGame> actual = service.add(null);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithIdNot0() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("New game must not have id set.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithNoTitle() throws DataAccessException {
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
    void shouldNotAddGameWithRatingUnder1() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setRating(0.9);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game rating must be 1-10.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithRatingOver10() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setRating(10.1);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game rating must be 1-10.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithMinPlayersUnder1() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMinimumPlayers(0);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Minimum players must be 1-100.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithMinPlayersOver100() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMinimumPlayers(101);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(2, actual.getMessages().size());
        assertEquals("Minimum players must be 1-100.", actual.getMessages().get(0));
        assertEquals("Maximum players must be more than minimum players.", actual.getMessages().get(1));
    }

    @Test
    void shouldNotAddGameWithMaxPlayersUnder1() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMaximumPlayers(0);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(2, actual.getMessages().size());
        assertEquals("Maximum players must be 1-100.", actual.getMessages().get(0));
        assertEquals("Maximum players must be more than minimum players.", actual.getMessages().get(1));
    }

    @Test
    void shouldNotAddGameWithMaxPlayersOver100() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMaximumPlayers(101);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Maximum players must be 1-100.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithMaxPlayersLessThanMinPlayers() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setMaximumPlayers(1);
        boardGame.setMinimumPlayers(2);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Maximum players must be more than minimum players.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithNullWeight() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeNewBoardGame(BoardGameWeight.HEAVY);
        boardGame.setWeight(null);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Weight is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddGameWithDuplicateTitle() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);
        boardGame.setBoardGameId(0);

        Result<BoardGame> actual = service.add(boardGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game already exists, title: \"Test Title1\"", actual.getMessages().get(0));
    }

    @Test
    void shouldUpdateGame() throws DataAccessException {
        BoardGame boardGame = TestHelpers.makeExistingBoardGame();
        Result<BoardGame> actual = service.update(boardGame);

        assertTrue(actual.isSuccess());
    }

    @Test
    void shouldNotUpdateMissingGame() throws DataAccessException {
        BoardGame game = TestHelpers.makeBoardGame(9, BoardGameWeight.HEAVY);

        Result<BoardGame> actual = service.update(game);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game 9 not found.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateNullGame() throws DataAccessException {
        Result<BoardGame> actual = service.update(null);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateGameWith0Id() throws DataAccessException {
        BoardGame game = TestHelpers.makeNewBoardGame(BoardGameWeight.MEDIUM);
        game.setTitle("Not existing");

        Result<BoardGame> actual = service.update(game);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Existing game must not have id set.", actual.getMessages().get(0));
    }

    @Test
    void shouldDeleteById() throws DataAccessException {
        BoardGame game = TestHelpers.makeExistingBoardGame();
        Result<Void> actual = service.deleteById(game.getBoardGameId());

        assertTrue(actual.isSuccess());
    }

    @Test
    void shouldNotDeleteMissingById() throws DataAccessException {
        Result<Void> actual = service.deleteById(99);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Board game 99 not found.", actual.getMessages().get(0));
    }
}