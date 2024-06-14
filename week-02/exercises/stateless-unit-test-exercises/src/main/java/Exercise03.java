import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise03 {

    // 1. Read the hasAllVowels JavaDocs.
    // 2. Complete the hasAllVowels method.
    // 3. Create tests to fully test hasAllVowels and confirm that it's 100% correct.

    /**
     * Determines if a String contains all English vowels: a, e, i, o, and u.
     * Both uppercase and lowercase vowels are allowed.
     * The `null` value should return false.
     *
     * @param value the string to test
     * @return true if the value contains all 5 vowels, false if it doesn't
     */
    static boolean hasAllVowels(String value) {


//    Scanner scanner = new Scanner(System.in);
        String testInput = "We will rock you.";
        String vowels = "aeiou";
        int vowelCount = 0;
        for (int i = 0; i < testInput.length(); i++){
            if (testInput.contains(vowels))
        }
    }
}
