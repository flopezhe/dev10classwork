package learn.boardgames.data;

import learn.boardgames.models.BoardGame;

import java.util.List;

public interface BoardGameRepository {
    List<BoardGame> findAll();

    List<BoardGame> findByNumberOfPlayers(int numberOfPlayers);

    List<BoardGame> findByTitle(String title);

    BoardGame findById(int boardGameId);

    BoardGame add(BoardGame game);

    boolean update(BoardGame game);

    boolean deleteById(int boardGameId);
}
