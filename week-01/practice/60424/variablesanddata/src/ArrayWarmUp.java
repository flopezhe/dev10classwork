import java.util.Scanner;

public class ArrayWarmUp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Give me a car(Up to 3):");
        String firstCar = console.nextLine();
        String[] cars = new String[3];

        cars[0] = firstCar;
        System.out.println(cars[0]);
    }
}
