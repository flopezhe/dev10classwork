import java.util.Scanner;
public class CapsuleHotel {
    public static void main(String[] args) {
        String welcome = "\"Welcome to the Capsule Hotel\"";
        System.out.println(welcome);
        System.out.println("=".repeat(welcome.length()));
        Scanner console = new Scanner(System.in);
        System.out.println("Please provide the hotel capacity:");
        int capacity = Integer.parseInt(console.nextLine());
        String[] hotelBuilding = new String[capacity];

        String input;

        do {
            int availableRooms = 0;
            for(int i = 0; i<hotelBuilding.length; i++){
                if(hotelBuilding[i]== null){
                    availableRooms++;
                }
            }

            System.out.println("There are currently "+availableRooms + " available rooms");
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
                System.out.println("Please enter the Capsule Room # of the guest:");
                int roomNum = Integer.parseInt(console.nextLine());
                if(roomNum <= 0 || roomNum >= hotelBuilding.length){
                    return;
                } else if(hotelBuilding[roomNum-1] == null){
                    System.out.println("There is no one in Capsule Room#" +roomNum + ". Please enter a valid room");
                } else {
                    System.out.println("Great Capsule Room#"+roomNum+" has been checked out, you're all set!");
                    hotelBuilding[roomNum-1] = "[Empty Room]";
                }
            } else if(input.equals("3")){
                System.out.println("Please enter a capsule room # to display the occupancy around it:");
                int roomOccupancy = Integer.parseInt(console.nextLine());
                if (roomOccupancy <= 0 || roomOccupancy >= hotelBuilding.length){
                    System.out.println("Enter a valid capsule room #");
                } else {
                    int beginningRoom = Math.max(0, roomOccupancy-6);
                    int endingRoom = Math.min(hotelBuilding.length, roomOccupancy +5);
                    displayCapsuleHotelBuilding(hotelBuilding, beginningRoom, endingRoom);
                }

            } else if (input.equals("4")){
                System.out.println("Goodbye!");
            } else {
                System.out.println("Please enter a valid option");
            }

        } while (!input.equals("4"));

    }
    public static void addGuest(Scanner console, String[] capsuleHotelBuilding){

        System.out.println("Enter the Capsule Room # you want to add the guest to: ");
        int room = Integer.parseInt(console.nextLine());
        if(room <= 0 || room >= capsuleHotelBuilding.length ){
            System.out.println("That is not a valid room #");
            return;
        } else if (capsuleHotelBuilding[room-1] != null){
            System.out.println("Someone is already in Capsule Room#"+room+ ". Please check them out first or select another Capsule Room#!");
            return;
        }
        System.out.println("Guest Name:");
        String guestName = console.nextLine();
        System.out.println("Great, "+guestName+" has been checked in!");
        capsuleHotelBuilding[room-1] = guestName;
    }
    public static void displayCapsuleHotelBuilding(String[] capsuleHotelBuilding, int beginningRoom, int endingRoom){
        System.out.println("The total current building layout is below: ");
        for(int i = beginningRoom; i < endingRoom; i++){
            System.out.printf("Room #%s: %s%n", i+1, capsuleHotelBuilding[i] == null ? "[Empty Room]": capsuleHotelBuilding[i]);
        }
    }
}
