
import java.util.Arrays;
import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];
        musicians[0] = new Musician("Frank Ocean", 10);


        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        for(int i = 0; i < musicians.length; i++){
            Musician musician = new Musician();
            System.out.println("Who is your fav musician?");
            String response = console.nextLine();
            if(response.equalsIgnoreCase("End")){
                return;
            }
            musician.setName(response);
            System.out.println("What is their rating?");
            int rating = Integer.parseInt(console.nextLine());
            musician.setRating(rating);

        }
        for (Musician musician: musicians) {
            System.out.printf("%s%n %s%n",musician.getName(), musician.getRating());
        }
        // (Replace Frank Ocean.)
        // Create musicians from user input. (See Exercise04.)

        // 2. Use a second loop to print details about each musician.
    }
}
