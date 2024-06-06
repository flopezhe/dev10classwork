public class Exercise04 {

    public static void main(String[] args) {
        System.out.println(getFirstVowel("magnificent")); // Expected: a
        System.out.println(getFirstVowel("winsome")); // Expected: i
        System.out.println(getFirstVowel("xxx")); // Expected: 0

        System.out.println(getFirstVowel("ajwefjawejf")); // Expected : a
        // 2. Call getFirstVowel at least one more time.
    }

    // getFirstVowel returns the first vowel in a string as a char.
    // 1. Complete getFirstVowel.
    // If no vowel is found, return 0. (As a char, 0 represents the NULL value.)
    public static char getFirstVowel(String value) {
        String vowels = "aeiou";

        for (int i = 0; i < value.length(); i++) {
            if (vowels.indexOf(value.charAt(i)) != -1) {
                return value.charAt(i);
            }
        }

        return 0;


    }
}

