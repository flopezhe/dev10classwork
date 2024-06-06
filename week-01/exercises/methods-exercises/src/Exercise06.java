public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(isBetween(4,2,8));
        System.out.println(isBetween(1,2,4));
    }

    public static int isBetween(int a, int b, int c){
        boolean isTrue = true;
        if (a > b && a < c){
            System.out.println(isTrue);
        } else {
            isTrue = false;
            System.out.println(isTrue);
        }
        return 0;
    }

}
