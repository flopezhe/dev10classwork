import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void testAeiouHasAllVowels(){
        String input = "aeiou";
        assertTrue(Exercise03.hasAllVowels(input));
    }
}