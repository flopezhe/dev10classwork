public class Exercise01 {

    public static void main(String[] args) {

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());

        // 1. Find the Musician class in this project.
        // Musician class is at the bottom!!!!
        // 2. Read its constructor comments.
        // @Contract(pure = true)
        //public Musician(     String name,
        //    int rating )
        // 3. Instantiate two more musicians and assign them to new variables.
        Musician ye = new Musician ("Ye", 1);
        System.out.println(ye.getName());

        // 4. Print the musicians' names to the console.

    }
}
