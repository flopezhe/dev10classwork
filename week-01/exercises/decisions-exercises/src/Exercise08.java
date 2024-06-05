import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        // OPPOSITES
        // Given a word, print its opposite.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = console.nextLine();
        String opposite = null;

        // 1. Add at least two more opposites by adding `else if` clauses.
        if (word.equalsIgnoreCase("high")) {
            opposite = "low";
            System.out.println(opposite);
        } else if (word.equalsIgnoreCase("cold")) {
            opposite = "hot";
            System.out.println(opposite);
        } else if (word.equalsIgnoreCase("little")) {
            opposite = "big";
            System.out.println(opposite);
        } else if(word.equalsIgnoreCase("fast")) {
            opposite = "slow";
            System.out.println(opposite);
        } else if( word.equalsIgnoreCase("strong")) {
            opposite = "weak";
            System.out.println(opposite);
        } else{
            System.out.printf("I don't have an opposite for %s.%n", word);
        }
    }
}
