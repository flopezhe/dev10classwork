package learn.gomoku.UI;

import learn.gomoku.game.Gomoku;
import learn.gomoku.players.RandomPlayer;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public static void playGame(){
        boolean gameIsOver = false;
        do {
            System.out.println("Please select your player!");
            System.out.println("1. Human Player");
            System.out.println("2. Random Player");
            Scanner scanner = new Scanner(System.in);
            Integer choiceOfPlayer = Integer.parseInt(scanner.nextLine());
            if (choiceOfPlayer == 1) {
                System.out.println("What is your first name?");
                String firstName = scanner.nextLine();
                System.out.println("What is your last name?");
                String lastName = scanner.nextLine();
                System.out.println(firstName + " " + lastName + " is the first player.");
                return;
            } else if (choiceOfPlayer == 2) {
                RandomPlayer computerPlayer = new RandomPlayer();
                String opponentName = computerPlayer.getName();
                System.out.println(opponentName + " is the first player.");
                return;
            }
            System.out.println(choiceOfPlayer + " is the first PLAYER.");
        }while(!gameIsOver);

    }

    public static void playerOneChoices(){

    }
}
