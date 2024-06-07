import java.util.Scanner;
public class CapsuleHotel {
    public static void main(String[] args) {
        String welcome = "\"Welcome to the Capsule Hotel\"";
        System.out.println(welcome);
        System.out.println("=".repeat(welcome.length()));
        Scanner console = new Scanner(System.in);
        String[] hotelBuilding = new String[100];

//        String selection = console.nextLine();

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
            } else if(input.equals("2")){
                System.out.println("Great, lets checkout the guest");
                System.out.println("Please enter the room number of the guest:");
                int roomNum = Integer.parseInt(console.nextLine());
                if(roomNum <= 0 || roomNum >= hotelBuilding.length){
                    return;
                } else {
                    System.out.println("Great Room#"+roomNum+" has been checked out, you're all set!");
                    hotelBuilding[roomNum-1] = "[Empty Room]";
                }
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

        System.out.println("Enter the room number you want to add the guest to: ");
        int room = Integer.parseInt(console.nextLine());
        if(room <= 0 || room >= capsuleHotelBuilding.length){
            return;
        }
        System.out.println("Guest Name:");
        String guestName = console.nextLine();
        capsuleHotelBuilding[room-1] = guestName;
    }
    public static void displayCapsuleHotelBuilding(String[] capsuleHotelBuilding){
        System.out.println("The total current occupancy is below: ");
        for(int i = 0; i < capsuleHotelBuilding.length; i++){
            System.out.printf("Room #%s: %s%n", i+1, capsuleHotelBuilding[i] == null ? "[Empty Room]": capsuleHotelBuilding[i]);
        }
//        System.out.println(Arrays.toString(capsuleHotelBuilding));
    }
}
