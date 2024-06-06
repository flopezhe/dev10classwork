import java.util.Arrays;

public class Exercise06 {

    public static void main(String[] args) {
        int[] values = {18, 42, 54, 93, 22};

        // 1. Create a loop to calculate the sum of elements in `values`.
        // 2. Print the result.
        int sum = 0;
        for(int value = 0; value < values.length;value++){
            sum += values[value];
        }
        System.out.println(sum);
    }
}
