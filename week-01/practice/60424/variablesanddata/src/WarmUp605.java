import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner ;
public class WarmUp605 {
    public static void main(String[] args) {
//        int numString = int("1");
//        System.out.println(numString);

        Scanner console = new Scanner(System.in);
//
//        String next = console.nextLine();
//        do {
//            System.out.println("Knock Knock");
//            next = console.nextLine();
//        } while (!next.equalsIgnoreCase("Whos there?"));
//        do {
//            System.out.println("Yoda Lee");
//            next = console.nextLine();
//        } while (!next.equalsIgnoreCase("Yoda Lee Whoo"));
        System.out.println("Type a string, ill lyk if there is white space:");
        String input = console.nextLine() ;
        for (int i = 0; i < input.length(); i++){
            if (Character.isWhitespace(input.charAt(i))){
                System.out.println("There is white space!");
            }
        }
    }
}
/*
Knock Knock
* Work in pairs
* Write a program that tells a knock-knock joke
* _Simple version:_ press <kbd>Enter</kbd> to move the joke forward
* _More complex:_ require the correct responses from the user: "Who's there?", "Interrupting cow, who?", etc...
* Only use what you've learned up to this point in the course!
* 30 minutes
* Switch 1/2 way through the exercise

Optional features:

* Randomly select a joke to tell from 3 knock knock jokes
* Prompt the user to enter the number of the joke to tell
* After telling the joke, ask the user if they want to hear another joke
 */
