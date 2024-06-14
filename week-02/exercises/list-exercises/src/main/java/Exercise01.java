import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.List;

public class Exercise01 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        List<Integer> gameTest = new ArrayList<>();

        // 1. Grab the 6th game from `games` (index 5).
        // 2. Print it to stdout. (Expected: "7 Wonders")

        System.out.println(games.get(5));

    }
}
