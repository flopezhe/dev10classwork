package learn.boardgames.data;

import learn.boardgames.TestHelpers;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameFileRepositoryTest {

    static String SEED_FILE_PATH = "./data/board-games-seed.csv";
    static String TEST_FILE_PATH = "./data/board-games-test.csv";

    BoardGameFileRepository boardGameFileRepository = new BoardGameFileRepository(TEST_FILE_PATH);

    @BeforeEach
    void setupTestFile() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAllGames() throws DataAccessException {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        List<BoardGame> actual = boardGameFileRepository.findAll();

        assertNotNull(actual);
        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindTest1WithFindByNumberOfPlayers1() throws DataAccessException {
        List<BoardGame> expected = List.of(TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM));

        List<BoardGame> actual = boardGameFileRepository.findByNumberOfPlayers(1);

        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByTitle() throws DataAccessException {
        List<BoardGame> expected = List.of(TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT));

        List<BoardGame> actual = boardGameFileRepository.findByTitle("2");

        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindLunarRushById() throws DataAccessException {
        BoardGame expected = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        BoardGame actual = boardGameFileRepository.findById(1);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindByIdForNotExistingId() throws DataAccessException {
        assertNull(boardGameFileRepository.findById(99));
    }

    @Test
    void shouldAddBoardGame() throws DataAccessException {
        BoardGame game = new BoardGame(0, "Chess, 1475", 7.2, 2, 2, true, BoardGameWeight.HEAVY);
        BoardGame expected = new BoardGame(4, "Chess, 1475", 7.2, 2, 2, true, BoardGameWeight.HEAVY);
        BoardGame actual = boardGameFileRepository.add(game);

        assertEquals(expected, actual);

        BoardGame byId = boardGameFileRepository.findById(4);

        assertEquals(expected, byId);
        assertEquals(4, boardGameFileRepository.findAll().size());
    }

    @Test
    void shouldUpdateCatan() throws DataAccessException {
        BoardGame gameToUpdate = TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM);
        gameToUpdate.setCheckedOut(false);
        gameToUpdate.setRating(7.2);
        gameToUpdate.setMinimumPlayers(1);
        gameToUpdate.setMaximumPlayers(5);
        gameToUpdate.setWeight(BoardGameWeight.LIGHT);

        assertTrue(boardGameFileRepository.update(gameToUpdate));
        assertEquals(gameToUpdate, boardGameFileRepository.findById(3));
    }

    @Test
    void shouldNotUpdateMissingGame() throws DataAccessException {
        BoardGame gameToUpdate = new BoardGame(99, "Catan", 7.1, 3, 4, true, BoardGameWeight.MEDIUM);
        assertFalse(boardGameFileRepository.update(gameToUpdate));
    }

    @Test
    void shouldDeleteCatanById() throws DataAccessException {
        assertTrue(boardGameFileRepository.deleteById(3));
        assertFalse(boardGameFileRepository.deleteById(3));
    }
}