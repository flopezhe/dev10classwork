public class Exercise23 {

    public static void main(String[] args) {

        String colors = "red orange yellow green blue indigo violet";
        System.out.println(colors.substring(0, 3));

        // 1. Use the substring method to print each color on its own line.
        // "red" is already complete.
        System.out.println(colors.substring(4,10));
        // Expected Output:
        // red
        // orange
        // yellow
        // green
        // blue
        // indigo
        // violet
    }
}
