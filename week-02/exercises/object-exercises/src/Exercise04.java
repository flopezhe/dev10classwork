import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // 1. Add an empty constructor to Musician.
        // 2. Uncomment the code below and make sure it runs.
        Musician m = new Musician();
        boolean isEnded = false;

        do{
            System.out.print("Musician name:");
            String input = (console.nextLine());
            m.setName(input);
            if(input.equalsIgnoreCase("End")){
                return;
            }
            System.out.print("Musician rating:");
            int rating = Integer.parseInt(console.nextLine());
            m.setRating(rating);
            System.out.println("\nArtist name:"+m.getName() +"\nRating:"+ m.getRating());
        } while(!isEnded);
        // print them out until the user types "end".
    }
}
