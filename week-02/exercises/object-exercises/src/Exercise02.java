public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);


        System.out.println(ocean.getName());
        // 2. Uncomment the line below and insure that it compiles and runs.

         System.out.println(ocean.rating);

        // 3. Instantiate two musicians and assign them to new variables.

        Musician jonBellion = new Musician ("Jon Bellion", 100);
        Musician ye = new Musician("Ye", 100);
        System.out.println(jonBellion.getName() + " " + jonBellion.getRating());
        System.out.println(ye.getName()+" "+ ye.getRating());
        // 4. Print each musicians' name and rating on a single line.
    }


}
