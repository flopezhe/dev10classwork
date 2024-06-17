package learn.gomoku.UI;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private final static int WIDTH = Gomoku.WIDTH;
    public static Player player1;
    public static Player player2;
    public static Gomoku gamePlayers;

//    public static List<Stone> stones = new ArrayList<>();
    private static boolean isPlayer1Human;
    private static boolean isPlayer2Human;



    public static void playGame(){

        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
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
            System.out.println(secondPlayerInGame + " is the Second Player!");

            gamePlayers = new Gomoku(player1, player2);

            Player currentPlayer = gamePlayers.getCurrent();

            while (!gamePlayers.isOver()) {
                boardWorld();
                System.out.println(currentPlayer.getName() + "'s turn");
                Stone move;
                if ((currentPlayer == player1 && isPlayer1Human) || (currentPlayer == player2 && isPlayer2Human)) {
                    move = getHumanPlayerMove(scanner, gamePlayers.isBlacksTurn());
                } else {
                    move = currentPlayer.generateMove(gamePlayers.getStones());
                }

                Result result = gamePlayers.place(move);

                if (!result.isSuccess()) {
                    System.out.println(result.getMessage());
                }

                currentPlayer = gamePlayers.getCurrent();
            }

            if (gamePlayers.getWinner() != null) {
                System.out.println(gamePlayers.getWinner().getName() + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            playAgain = isPlayAgain(scanner);

        } while (playAgain);

        System.out.println("Thank you for playing Gomoku!");
    }

    // USED INTELLIJ EXTRACT METHOD, I BELIEVE ITS WORKING RIGHT LAST CODE CHANGED MON 12 AM NO ISSUES
    private static boolean isPlayAgain(Scanner scanner) {
        boolean playAgain;
        System.out.println("Do you want to play again? (y/n)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            playAgain = true;
        } else if (response.equalsIgnoreCase("n")) {
            playAgain = false;
        } else {
            System.out.println("Invalid response. TOO BAD");
            playAgain = false;
        }
        return playAgain;
    }

    private static Stone getHumanPlayerMove(Scanner scanner, boolean isBlack) {
        int row;
        int col;
        while (true) {
            System.out.println("Enter row (1-15):");
            row = Integer.parseInt(scanner.nextLine())-1;
            System.out.println("Enter column (1-15):");
            col = Integer.parseInt(scanner.nextLine()) - 1;

            if (row >= 0 && row < WIDTH && col >= 0 && col < WIDTH) {
                break;
            } else {
                System.out.println("Invalid move. Please enter values between 1 and 15.");
            }
        }
        return new Stone(row, col, isBlack);
    }

    public static void boardWorld() {
        char[][] board = new char[WIDTH][WIDTH];
        for (char[] row : board) {
            for (int i = 0; i < WIDTH; i++) {
                row[i] = '-';
            }
        }

        for (Stone stone : gamePlayers.getStones()) {
            board[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'B' : 'W';
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
                isPlayer1Human= true;
            } else {
                player2 = humanPlayer;
                isPlayer2Human=true;
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
