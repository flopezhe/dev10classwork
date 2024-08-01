package learn.boardgames.data;

import learn.boardgames.TestHelpers;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BoardGameJdbcTemplateRepositoryTest {

    private static final int MISSING_ID = 99;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BoardGameJdbcTemplateRepository repository;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state()");
    }

    @Test
    void shouldFindAll() {

        List<BoardGame> expected = List.of(
            TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
            TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
            TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        List<BoardGame> actual = repository.findAll();

        assertEquals(expected, actual);
        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNumberOfPlayersOne() {
        List<BoardGame> expected = List.of(TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM));

        List<BoardGame> actual = repository.findByNumberOfPlayers(1);

        assertEquals(expected, actual);
        assertEquals(1, actual.size());
    }

    @Test
    void shouldFindByTitle() {
        List<BoardGame> expected = List.of(TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT));

        List<BoardGame> actual = repository.findByTitle("2");

        assertEquals(expected, actual);
        assertEquals(1, actual.size());
    }

    @Test
    void shouldFindById() {
        BoardGame expected = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        BoardGame actual = repository.findById(1);

        assertEquals(expected, actual);
        assertEquals(2, actual.getPublishers().size());
        assertTrue(actual.getPublishers().stream().anyMatch(p -> p.getPublisher().getPublisherId() == 1));
    }

    @Test
    void shouldAddBoardGame() {
        BoardGame expected = TestHelpers.makeBoardGame(4, BoardGameWeight.CASUAL);
        BoardGame gameToAdd = TestHelpers.makeBoardGame(4, BoardGameWeight.CASUAL);
        gameToAdd.setBoardGameId(0);

        BoardGame actual = repository.add(gameToAdd);

        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateBoardGame() {
        BoardGame toUpdate = TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT);
        toUpdate.setRating(9.5);
        toUpdate.setMinimumPlayers(1);
        toUpdate.setMaximumPlayers(5);
        toUpdate.setWeight(BoardGameWeight.MEDIUM);
        toUpdate.setCheckedOut(false);

        assertTrue(repository.update(toUpdate));

        BoardGame updatedGame = repository.findById(2);

        assertEquals(toUpdate, updatedGame);
    }

    @Test
    void shouldNotUpdateMissingBoardGame() {
        BoardGame toUpdate = TestHelpers.makeBoardGame(MISSING_ID, BoardGameWeight.MEDIUM);

        assertFalse(repository.update(toUpdate));
    }

    @Test
    void shouldDeleteById() {
        assertTrue(repository.deleteById(3));
        assertNull(repository.findById(3));
    }

    @Test
    void shouldNotDeleteMissingById() {
        assertFalse(repository.deleteById(MISSING_ID));
    }
}