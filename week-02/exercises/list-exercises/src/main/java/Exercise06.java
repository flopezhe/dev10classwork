import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise06 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Use a loop to find the game in `games` that can be played by the most players.
        // 2. Print the game. (Expected: "Ultimate Werewolf...")
        BoardGame gameWithMostPlayers = null;
        if(!games.isEmpty()){
            gameWithMostPlayers = games.get(0);
        }
        for(BoardGame game : games){
            gameWithMostPlayers = game.getMaxPlayers() > gameWithMostPlayers.getMaxPlayers()
                    ? game : gameWithMostPlayers;
        }

        System.out.println(gameWithMostPlayers);
    }
}

