public class Vampire extends Enemy{


    public static void main(String[] args) {
        Vampire vampire = new Vampire();

        vampire.setHealth(25);

        System.out.println(vampire.getHealth());
        vampire.attack();
    }
}
