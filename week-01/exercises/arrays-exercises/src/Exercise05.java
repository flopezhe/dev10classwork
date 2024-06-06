public class Exercise05 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's continents.
        // Do not use array literal notation. Allocate space for 6 continents and then set each value by index.
        // 2. Loop over each element and print it.
        String [] worldsContinents = new String[6];
        worldsContinents[0]="Asia";
        worldsContinents[1]= "Africa";
        worldsContinents[2]= "North America";
        worldsContinents[3]="South America";
        worldsContinents[4]="Antartica";
        worldsContinents[5]="Europe";
        for(int continent = 0; continent < worldsContinents.length; continent++){
            System.out.println(worldsContinents[continent]);
        }
    }
}
