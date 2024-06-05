import java.util.Scanner;
public class Lab605 {

    public static void main(String[] args) {
        String welcome = "Welcome to Clue. You have to find the murder weapon.";
        System.out.println(welcome);
        System.out.println("=".repeat(welcome.length()));
        Scanner console = new Scanner(System.in);
        String currentRoom = "living room";
        String murderWeapon = "axe";
        boolean hasWeapon = false;
        do {
            System.out.printf("You are in the %s%n", currentRoom);
            switch (currentRoom) {
                case "living room":
                    System.out.println("What would you like to do?");
                    System.out.println("1. Look under the couch cushions.");
                    System.out.println("2. Look behind the painting on the wall.");
                    System.out.println("3. Go to the master bedroom.");
                    System.out.println("4. Go to the kitchen.");

                    String response = console.nextLine();
                    switch (response) {
                        case "1":
                            System.out.println("Nothing there.");
                            break;
                        case "2":
                            System.out.println("Nothing there.");
                            break;
                        case "3":
                            currentRoom = "master bedroom";
                            break;
                        case "4":
                            currentRoom = "kitchen";
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                            break;
                    }
                    break;
                case "kitchen":
                    System.out.println("What would you like to do?");
                    System.out.println("1. Search the drawers.");
                    System.out.println("2. Go back to the living room.");
                    response = console.nextLine();
                    switch (response) {
                        case "1":
                            if (!hasWeapon) {
                                hasWeapon = true;
                                System.out.println("You found the weapon in the drawers!");
                                break;
                            }
                            break;
                        case "2":
                            currentRoom = "living room";
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                            break;
                    }
                    break;
                case "master bedroom":
                    System.out.println("What would you like to do?");
                    System.out.println("1. Search the drawers.");
                    System.out.println("2. Go back to the kitchen.");
                    response = console.nextLine();
                    switch (response){
                        case "1":
                            System.out.println("Nothing is there!");
                            break;
                        case "2":
                            currentRoom = "kitchen";
                            break;
                        default:
                            System.out.println("Invalid vhoice. Try again.");
                            break;
                    }
                    break;
            }

        } while (!hasWeapon);
        System.out.println("You won!");
    }
}