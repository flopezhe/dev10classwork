public class Exercise02 {

    public static void main(String[] args) {
        // 1. Write a loop to print positive even numbers less than 13.
        // Use whatever approach you see fit. (Could count by 2 or use a decision statement inside the loop.)

        for (int index = 0; index <= 13; index++) {

            if (index %2== 0){
                System.out.println(index);
            } else {
                System.out.println("not an even positive number");
            }
        }
        // Expected Output
        // 2
        // 4
        // 6
        // 8
        // 10
        // 12
    }
}
