package learn.boardgames.data;

import learn.boardgames.TestHelpers;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;

import java.util.List;

public class BoardGameRepositoryDouble implements BoardGameRepository {
    @Override
    public List<BoardGame> findAll() throws DataAccessException {
        return List.of(
            TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
            TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
            TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));
    }

    @Override
    public List<BoardGame> findByNumberOfPlayers(int numberOfPlayers) throws DataAccessException {
        return List.of(TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT));
    }

    @Override
    public List<BoardGame> findByTitle(String title) throws DataAccessException {
        return List.of();
    }

    @Override
    public BoardGame findById(int boardGameId) throws DataAccessException {
        return TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM);
    }

    @Override
    public BoardGame add(BoardGame game) throws DataAccessException {
        return TestHelpers.makeBoardGame(5, BoardGameWeight.HEAVY);
    }

    @Override
    public boolean update(BoardGame game) throws DataAccessException {
        BoardGame existing = TestHelpers.makeExistingBoardGame();
        return game.getBoardGameId() == existing.getBoardGameId();
    }

    @Override
    public boolean deleteById(int boardGameId) throws DataAccessException {
        BoardGame existing = TestHelpers.makeExistingBoardGame();
        return boardGameId == existing.getBoardGameId();
    }
}
