package learn.gomoku;

import learn.gomoku.UI.Controller;

import java.util.Scanner;


import static learn.gomoku.UI.Controller.playGame;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String welcomeIntro = "Welcome to Gomoku!";
        System.out.println(welcomeIntro);
        System.out.println("=".repeat(welcomeIntro.length()));

        playGame();

    }
}
