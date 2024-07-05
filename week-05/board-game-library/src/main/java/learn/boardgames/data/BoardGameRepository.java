package learn.boardgames.data;

import learn.boardgames.models.BoardGame;

import java.util.List;

public interface BoardGameRepository {
    List<BoardGame> findAll() throws DataAccessException;

    List<BoardGame> findByNumberOfPlayers(int numberOfPlayers) throws DataAccessException;

    List<BoardGame> findByTitle(String title) throws DataAccessException;

    BoardGame findById(int boardGameId) throws DataAccessException;

    BoardGame add(BoardGame game) throws DataAccessException;

    boolean update(BoardGame game) throws DataAccessException;

    boolean deleteById(int boardGameId) throws DataAccessException;
}
