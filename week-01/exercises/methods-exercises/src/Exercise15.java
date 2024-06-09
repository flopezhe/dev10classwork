import java.util.Scanner;

public class Exercise15 {
    /* FIZZ BUZZ

    Historically, the Fizz Buzz (https://en.wikipedia.org/wiki/Fizz_buzz) problem was used in programming interviews.
    Not sure if it still is. Just in case, we'll get it out of the way in Milestone 1.

    Write a program to:
    - Prompt a user for a positive integer and store the result. (Could reuse a readInt method.)
    - Loop from the number 1 to the user's integer.
    - If the number is divisible by 3, print Fizz.
    - If the number is divisible by 5, print Buzz.
    - If the number is divisible by both 3 and 5, print Fizz Buzz.
    - If the number is not divisible by either 3 or 5, print the number.

   */
    public static void main(String[] args) {

//        Scanner console = new Scanner(System.in);
//        System.out.println("Give me a positive integer: ");
//        int input = Integer.parseInt(console.nextLine());
        findTheFizzBuzz();

    }
    public static void findTheFizzBuzz(){

        Scanner console = new Scanner(System.in);
        System.out.println("Give me a positive integer: ");
        int input = Integer.parseInt(console.nextLine());
        for(int i = 0; i <= input; i++){
            if((i%5 == 0) && (i%3==0)){
                System.out.println("FizzBuzz");
            } else if(i%5==0){
                System.out.println("Buzz");
            } else if(i%3==0){
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
