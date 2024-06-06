import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        rand.nextInt();

        Scanner console = new Scanner(System.in);

        String title = "Welcome to Cat Adventure. You're a cat. You need to find your mouse.";
        System.out.println(title);
        System.out.println("=".repeat(title.length()));

        boolean hasFoundMouse = false;

        String livingroom = "living room";
        String kitchen = "kitchen";

        String currentRoom = livingroom;

        do {

            System.out.printf("You are in the %s.%n", currentRoom);

            if (currentRoom.equals(livingroom)) {
                System.out.println("What would you like to do?");
                System.out.printf("1. Go to %s%n", kitchen);
                System.out.println("2. Sniff around");
                System.out.println("Choose [1-2]: ");
                String choice = console.nextLine();

                if (choice.equals("1")) {
                    currentRoom = "kitchen";
                    System.out.printf("You have moved to the %s.%n", kitchen);
                } else {
                    System.out.println("You sniff around and smell nothing.");
                }
            } else {
                System.out.println("What would you like to do?");
                System.out.printf("1. Go to %s%n", livingroom);
                System.out.println("2. Sniff around");
                System.out.println("Choose [1-2]: ");
                String choice = console.nextLine();

                if (choice.equals("1")) {
                    currentRoom = livingroom;
                    System.out.println("You have moved to the l.");
                } else {
                    hasFoundMouse = true;
                    System.out.println("You found the mouse!");
                }
            }
        } while (!hasFoundMouse);

        System.out.println("Congrats, you win!");

    }
}
