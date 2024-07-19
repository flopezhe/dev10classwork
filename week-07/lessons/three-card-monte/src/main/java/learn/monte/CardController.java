package learn.monte;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CardController {
    WinningCard winningCard = new WinningCard();

    private int winCount = 0;
    private int lossCount = 0;
    private int gameId = 0;
    HashMap<Integer, Integer> winMap = new HashMap<>();

    @GetMapping("/start")
    public String instructions(){
        gameId++;
        winMap.put(gameId, 0);
        System.out.println(gameId);
        return String.format("Pick a card from 1-3, if you select the winning card you win, if not, you lose.%n%n");
    }

    @GetMapping("/status")
    public String status(){
        return String.format("Win Count: %s%n Loss Count: %s%n",winCount,lossCount);
    }

    @PostMapping("/start")
    public void startGame() {
        winningCard.setNum((int) (Math.random() * 3)+1);
        System.out.println(winningCard.getNum());
    }

    @PostMapping("/play/{gameId}/{number}")
    public String play(@PathVariable int gameId, @PathVariable int number) {
        if (winMap.containsKey(gameId)) {
            if (number == winningCard.getNum()) {
                winCount++;
                winMap.put(gameId, winCount);
                return "Winner";
            return "Loser";
        }
        return "Invalid game id";
    }

}
