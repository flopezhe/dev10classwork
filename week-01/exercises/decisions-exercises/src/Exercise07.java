import java.util.Scanner;

public class Exercise07 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Hours of homework: ");
        int hoursOfHomework = Integer.parseInt(console.nextLine());

        System.out.println("Day of the week: ");
        String dayOfWeek = console.nextLine();
        // HOMEWORK
        // Abdi decides if he should do homework using the following criteria:
        // If the day of the week starts with "S" and he has less than 15 hours of homework, he skips homework for the day.
        // If the day of the week starts with any other letter or he has more than 15 hours of homework, he does his homework.
        // 1. Create if/else statements to enforce Abdi's homework rules.
        // 2. Print data-rich messages for each scenario.
        if ((dayOfWeek.startsWith("S")) && (hoursOfHomework < 15)){
            System.out.println("Do homework");
        } else {
            System.out.println(" yay no homework!");
        }

        // Examples
        // Hours of homework: 12
        // Day of week: Saturday
        // I'm taking the day off!
        //
        // Hours of homework: 2
        // Day of week: Thursday
        // Time to do the homework...
        //
        // Hours of homework: 20
        // Day of week: Sunday
        // Time to do the homework...
    }
}
