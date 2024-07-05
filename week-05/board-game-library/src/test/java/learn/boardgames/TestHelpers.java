package learn.boardgames;

import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;

public class TestHelpers {

    public static BoardGame makeBoardGame(int id, BoardGameWeight weight) {
        return new BoardGame(id, "Test Title" + id, Math.abs(10 - id), id, id + 3, id % 2 == 0, weight);
    }

    public static BoardGame makeNewBoardGame(BoardGameWeight weight) {
        BoardGame game = makeBoardGame(1, weight);
        game.setBoardGameId(0);
        return game;
    }

    public static BoardGame makeExistingBoardGame() {
        return TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM);
    }
}
