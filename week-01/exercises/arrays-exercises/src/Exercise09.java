public class Exercise09 {

    public static void main(String[] args) {
        String[] haystack = makeHaystack();

        // A needle is randomly placed in a haystack array with a capacity of 100.
        // 1. Loop through the haystack and find the needle.
        // 2. Print the index where you found it.
        for(int values = 0; values < haystack.length; values ++){
            if(haystack[values] != null){
                System.out.println("Found needle! it is located in"+values);;
            }

            // below is an example of technically correct but bad code, use .equals() for strings
//            if(haystack[values] == "needle"){
//                System.out.println("needle is in"+values);
//            }

            }
        }
        // Hint: this is an exercise about the default value of strings.


    public static String[] makeHaystack() {
        String[] haystack = new String[100];
        int index = (int) (Math.random() * haystack.length);
        haystack[index] = "needle";
        return haystack;
    }
}
