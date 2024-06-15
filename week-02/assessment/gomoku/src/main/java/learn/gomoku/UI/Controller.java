package learn.gomoku.UI;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {


    private final static int WIDTH = Gomoku.WIDTH;
    public static Player player1;
    public static Player player2;
    public static Gomoku gamePlayers = new Gomoku(player1, player2);
    public static List<Stone> stones = new ArrayList<>();



    public static void playGame(){
        boolean gameIsOver = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please select your first player!");
            System.out.println("1. Human Player");
            System.out.println("2. Random Player");
            Integer choiceOfFirstPlayer = Integer.parseInt(scanner.nextLine());
            String firstPlayerInGame = playerIsSelected(choiceOfFirstPlayer, true);

            System.out.println(firstPlayerInGame + " is the First Player!");

            System.out.println("Please select your second player!");
            System.out.println("1. Human Player");
            System.out.println("2. Random Player");
            Integer choiceOfSecondPlayer = Integer.parseInt(scanner.nextLine());
            String secondPlayerInGame = playerIsSelected(choiceOfSecondPlayer, false);
            System.out.println(secondPlayerInGame+ " is the Second Player!");

            gamePlayers = new Gomoku(player1, player2);
            boardWorld();
            System.out.println(player2.getName() + " it is your turn first");





        }while(!gameIsOver);

    }

    public static void boardWorld() {
        char[][] board = new char[WIDTH][WIDTH];
        for (char[] row : board) {
            for (int i = 0; i < WIDTH; i++) {
                row[i] = '-';
            }
        }

        for (Stone stone : gamePlayers.getStones()) {
            board[stone.getRow()-1][stone.getColumn()-1] = stone.isBlack() ? 'B' : 'W';
        }

        System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        for (int i = 0; i < WIDTH; i++) {
            System.out.printf("%2d ", i+1);
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }

    }


    public static String playerIsSelected(int choiceOfPlayer, boolean isFirstPlayer) {
        Scanner scanner = new Scanner(System.in);
        String playerName = "";

        if (choiceOfPlayer == 1) {
            System.out.println("What is your first name?");
            String firstName = scanner.nextLine();
            System.out.println("What is your last name?");
            String lastName = scanner.nextLine();
            playerName = firstName + " " + lastName;
            HumanPlayer humanPlayer = new HumanPlayer(playerName);
            if (isFirstPlayer) {
                player1 = humanPlayer;
            } else {
                player2 = humanPlayer;
            }
        } else if (choiceOfPlayer == 2) {
            RandomPlayer randomPlayer = new RandomPlayer();
            playerName = randomPlayer.getName();
            if (isFirstPlayer) {
                player1 = randomPlayer;
            } else {
                player2 = randomPlayer;
            }
        }

        return playerName;
    }

}
