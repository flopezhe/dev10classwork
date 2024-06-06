import java.util.Arrays;

public class Exercise04 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's oceans.
        // Set its value using array literal notation.
        // 2. Loop over each element and print it.
        String[] worldsOceans= {"Arctic", "North Atlantic", "South Atlantic", "North Pacific", "South Pacific","Indian", "Southern " };

        for(int ocean = 0 ; ocean <worldsOceans.length; ocean++){
            System.out.println(worldsOceans[ocean]);
        }
        //        System.out.println(Arrays.toString(worldsOceans));
    }
}
