import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Minimum value:");
        int minValue = Integer.parseInt(console.nextLine());
        System.out.println("Maximum value:");
        int maxValue = Integer.parseInt(console.nextLine());
        System.out.println("Actual value:");
        int actualValue = Integer.parseInt(console.nextLine());

        if (actualValue < maxValue && actualValue > minValue){
            System.out.println(actualValue);
        } else {
            System.out.println(actualValue + " is not in between " + maxValue + " and " + minValue);
            }
        }

    }

