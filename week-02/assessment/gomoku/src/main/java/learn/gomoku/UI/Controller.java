package learn.gomoku.UI;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.RandomPlayer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Controller {


    public static RandomPlayer computerPlayer1 = new RandomPlayer();
    public static RandomPlayer computerPlayer2 = new RandomPlayer();
    public static HumanPlayer humanPlayer1 ;
    public static HumanPlayer humanPlayer2 ;

    public static void setHumanPlayer1(HumanPlayer humanPlayer1){
        Controller.humanPlayer1 = humanPlayer1;
    }
    public static void setHumanPlayer2(HumanPlayer humanPlayer2){
        Controller.humanPlayer2 = humanPlayer2;
    }
    public static void setComputerPlayer1(RandomPlayer computerPlayer) {
        Controller.computerPlayer1 = computerPlayer;
    }

    public static void setComputerPlayer2(RandomPlayer computerPlayer1) {
        Controller.computerPlayer2 = computerPlayer1;
    }

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


            if(firstPlayerInGame.equals(computerPlayer1.getName())){
                System.out.println(computerPlayer1.getName() + " is a computer!");
            } else if(firstPlayerInGame.equals(humanPlayer1.getName())){
                System.out.println(humanPlayer1.getName() + " is a human");
            }

            if (secondPlayerInGame.equals(computerPlayer2.getName())){
                System.out.println(computerPlayer2.getName()+ " is a computer");
            } else if (secondPlayerInGame.equals(humanPlayer2.getName())) {
                System.out.println(humanPlayer2.getName() + " is a human.");
            }


        }while(!gameIsOver);

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
            setHumanPlayer1(humanPlayerTwo);

        } else if (choiceOf == 2) {
            RandomPlayer computerPlayerTwo = new RandomPlayer();
            setComputerPlayer2(computerPlayerTwo);
            String opponentName = computerPlayerTwo.getName();
            secondName = opponentName;


        }
        return secondName;
    }
}
