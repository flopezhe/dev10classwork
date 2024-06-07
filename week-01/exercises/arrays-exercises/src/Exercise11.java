import java.util.Arrays;
import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();
        int totalPositiveElements = 0;
        for(int element = 0; element < values.length; element ++){
            if(values[element] > 0){
                totalPositiveElements += 1;
            }
        }
        System.out.println("There are " + totalPositiveElements + " Positive elements in the array");
        int[] positiveElements = new int[totalPositiveElements];
        int index = 0;
        for(int element = 0; element < values.length; element ++){
            if(values[element] > 0){
                positiveElements[index] = values[element];
                index ++;
            }
        }

        System.out.println(Arrays.toString(positiveElements));



        // 1. Count the number of positive elements in `values`.
        // 2. Create a new int[] to hold the positive elements.
        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.
        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }

}
