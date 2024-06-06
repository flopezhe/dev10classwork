public class Exercise16 {

    public static void main(String[] args) {
        // BORDER BOX
        // 1. Use nested loops to print a box in the console with a different character for the border.
        // One loop should represent rows and the other should represent columns.
        // The border character should be different from the internal box character.
        // 2. Change the row and column limit to change the shape of the box.
        int rows = 5;
        int columns = 5;
        String border = "*";
        String filler = "#";

        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){

                if(row == 0 || row == rows - 1 || column==0 || column == columns -1){
                    System.out.println(border);
                } else {
                    System.out.println(filler);
                }
            }
            System.out.println();
        }
        // Expected Output (5X5)
        // *****
        // *###*
        // *###*
        // *###*
        // *****

        // (3X4)
        // ****
        // *##*
        // ****

        // (2X2)
        // **
        // **
    }
}
