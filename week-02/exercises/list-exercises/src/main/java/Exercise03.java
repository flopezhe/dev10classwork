import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Add three new games to `games` with the `add` method.
        // 2. Print `games` after each add.

        games.add(1, new BoardGame("TikTakToe", 1, 2, "Competitive"));
        System.out.println(games);
        games.add(2, new BoardGame("Connect Four", 1,2,"Competitive"));
        System.out.println(games);
        games.add(3,new BoardGame("Charades", 1, 10,"Competitive" ));
        System.out.println(games);
    }
}
