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
    public static Stone stone = new Stone(0,0,true);
    public static RandomPlayer computerPlayer1 = new RandomPlayer();
    public static RandomPlayer computerPlayer2 = new RandomPlayer();
    public static HumanPlayer humanPlayer1 ;
    public static HumanPlayer humanPlayer2 ;
    public static Player player1;
    public static Player player2;
    public static Gomoku gamePlayers = new Gomoku(player1, player2);
    public static List<Stone> stones = new ArrayList<>();

    public static Stone getStone() {
        return stone;
    }

    public static void setStone(Stone stone) {
        Controller.stone = stone;
    }

    public static void setGamePlayers(Player player1, Player player2) {
        Controller.gamePlayers = new Gomoku(player1, player2);
    }


//    public static Player getGamePlayerOne(Gomoku gamePlayers) {
//        return player1;
//    }
//    public static Player getGamePlayerTwo(Gomoku gamePlayers){
//        return player2;
//    }
//STATIC TESTING, DO NOT USE STATIC WHEN UPDATING GAME IN REAL LIFE PURPOSES, STATIC ISNT IDEAL FOR ACTUAL GAMES
//    public static void setHumanPlayer1(HumanPlayer humanPlayer1){
//        Controller.humanPlayer1 = humanPlayer1;
//    }
//    public static void setHumanPlayer2(HumanPlayer humanPlayer2){
//        Controller.humanPlayer2 = humanPlayer2;
//    }
//    public static void setComputerPlayer1(RandomPlayer computerPlayer) {
//        Controller.computerPlayer1 = computerPlayer;
//    }
//
//    public static void setComputerPlayer2(RandomPlayer computerPlayer1) {
//        Controller.computerPlayer2 = computerPlayer1;
//    }

    public static void playGame(){
        boolean gameIsOver = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please select your first player!");
            System.out.println("1. Human Player");
            System.out.println("2. Random Player");
            Integer choiceOfFirstPlayer = Integer.parseInt(scanner.nextLine());
            String firstPlayerInGame = firstPlayerIsSelected(choiceOfFirstPlayer);

            System.out.println(firstPlayerInGame + " is the First Player!");

            System.out.println("Please select your second player!");
            System.out.println("1. Human Player");
            System.out.println("2. Random Player");
            Integer choiceOfSecondPlayer = Integer.parseInt(scanner.nextLine());
            String secondPlayerInGame = secondPlayerIsSelected(choiceOfSecondPlayer);
            System.out.println(secondPlayerInGame+ " is the Second Player!");

            /// REFACTOR, THIS ISNT IDEAL DYNAMICALLY
//            if(firstPlayerInGame.equals(computerPlayer1.getName()) && secondPlayerInGame.equals(computerPlayer2.getName())){
//                setGamePlayers(computerPlayer1, computerPlayer2);
//            } else if(firstPlayerInGame.equals(humanPlayer1.getName()) && secondPlayerInGame.equals(computerPlayer2.getName())){
//                setGamePlayers(humanPlayer1 , computerPlayer2);
//            }else if (firstPlayerInGame.equals(humanPlayer1.getName()) && secondPlayerInGame.equals(humanPlayer2.getName())){
//                setGamePlayers(humanPlayer1 , humanPlayer2);
//            } else if (firstPlayerInGame.equals(computerPlayer1.getName()) && secondPlayerInGame.equals(humanPlayer2.getName())) {
//                setGamePlayers(computerPlayer1 , humanPlayer2);
//            }


            if(firstPlayerInGame.equals(computerPlayer1.getName())){
                computerPlayer1.generateMove(stones);
                boardWorld();
                System.out.println(stones);
                System.out.println("TEST");
            }else if (firstPlayerInGame.equals(humanPlayer1.getName())){
                System.out.println(firstPlayerInGame+", what row do you want to move to?(1-15");
                Integer rowMove = Integer.parseInt(scanner.nextLine());
                if(rowMove<0 || rowMove>15) {
                    System.out.println("Invalid number");
                }
                System.out.println(firstPlayerInGame + ", what column do you want to move to?(1-15");
                Integer columnMove = Integer.parseInt(scanner.nextLine());
                if(columnMove<0 || columnMove>15) {
                    System.out.println("Invalid number");
                }
                    Stone moves = new Stone(rowMove - 1, columnMove - 1, true);
                    setStone(moves);
                    System.out.println(getStone());
                }



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
            board[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'B' : 'W';
        }

        System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        for (int i = 0; i < WIDTH; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }

    }


    public static String firstPlayerIsSelected(int firstChoice) {
        Scanner scanner = new Scanner(System.in);
        String firstPlayerName = "";
        if (firstChoice == 1 ) {
            System.out.println("What is your first name?");
            String firstName = scanner.nextLine();
            System.out.println("What is your last name?");
            String lastName = scanner.nextLine();
            firstPlayerName = firstName+" "+ lastName;
            HumanPlayer humanPlayerOne = new HumanPlayer(firstPlayerName);
            setHumanPlayer1(humanPlayerOne);


        } else if (firstChoice == 2) {
            RandomPlayer computerPlayerOne = new RandomPlayer();
            setComputerPlayer1(computerPlayerOne);
            String opponentName = computerPlayerOne.getName();
            firstPlayerName = opponentName;

        }
        return firstPlayerName;
    }

    public static String secondPlayerIsSelected(int choiceOf){
        Scanner scanner = new Scanner(System.in);
        String secondName = "";
        if (choiceOf == 1) {
            System.out.println("What is your first name?");
            String firstName = scanner.nextLine();
            System.out.println("What is your last name?");
            String lastName = scanner.nextLine();
            secondName=firstName + " "+ lastName;
            HumanPlayer humanPlayerTwo = new HumanPlayer(secondName);
            setHumanPlayer2(humanPlayerTwo);

        } else if (choiceOf == 2) {
            RandomPlayer computerPlayerTwo = new RandomPlayer();
            setComputerPlayer2(computerPlayerTwo);
            String opponentName = computerPlayerTwo.getName();
            secondName = opponentName;

        }
        return secondName;
    }
}
