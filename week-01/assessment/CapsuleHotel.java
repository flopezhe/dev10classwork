import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class CapsuleHotel {
    public static void main(String[] args) {
        String welcome = "\"Welcome to the Capsule Hotel\"";
        System.out.println(welcome);
        System.out.println("=".repeat(welcome.length()));
        System.out.println("Press Enter to continue");
        Scanner console = new Scanner(System.in);
        String[] hotelBuilding = new String[100];

        String selection = console.nextLine();

        String input;

        do {
            System.out.println("Main Menu");
            System.out.println("1. Book a Guest");
            System.out.println("2. Checkout a Guest");
            System.out.println("3. Check Current Occupancy");
            System.out.println("4. Exit");
            System.out.println("Please select 1-4:");
            input = console.nextLine();
            if (input.equals("1")) {
                addGuest(console, hotelBuilding);
                displayCapsuleHotelBuilding(hotelBuilding);
                break;
            } else if(input.equals("2")){
                System.out.println("Great, lets checkout the guest");
            } else if(input.equals("3")){
                displayCapsuleHotelBuilding(hotelBuilding);
            } else if (input.equals("4")){
                System.out.println("Goodbye!");
            } else {
                System.out.println("Please enter a valid option");
            }

        } while (!input.equals("4"));


    }

    public static void addGuest(Scanner console, String[] capsuleHotelBuilding){
        System.out.println("Great lets book a guest, please enter the guest name:");
        System.out.println("Enter the room number you want to add the guest to: ");
        int room = Integer.parseInt(console.nextLine());
        if(room < 0 || )
    }
    public static void displayCapsuleHotelBuilding(String[] capsuleHotelBuilding){
        System.out.println("The total current occupancy is below: ");
        for(int i = 0; i < capsuleHotelBuilding.length; i++){
            System.out.printf("Room #%s: %s%n", i+1, capsuleHotelBuilding[i] == null ? "[Empty Room]": capsuleHotelBuilding[i]);
        }
//        System.out.println(Arrays.toString(capsuleHotelBuilding));
    }
}
