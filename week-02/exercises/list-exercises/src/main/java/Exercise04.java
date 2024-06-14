import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise04 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame>.
        // 2. Add three BoardGames to the new list.
        // 3. Print the new list.
        // 4. Add items in the new list to `games` with the `addAll` method.
        // 5. Print `games`.

        ArrayList<BoardGame> twoPlayerGames = new ArrayList<>();
        twoPlayerGames.add(0, new BoardGame("Random1", 1,2,"Competitive"));
        twoPlayerGames.add(1,new BoardGame("Random2", 1,2,"Competitive"));
        System.out.println(twoPlayerGames);
        games.addAll(twoPlayerGames);
        System.out.println(games);
    }
}
