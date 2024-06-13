import java.util.Random;
import java.util.Scanner;

public class Game {

    // constants
    private final static int WIDTH = 10;
    private final static String WALL_CHARACTER = "M";
    private final static String EMPTY_CHARACTER = " ";

    private final Scanner console = new Scanner(System.in);
    private Hero hero;
    private Treasure treasure;
    private boolean isOver;
    private Trap trap;
    private Trap trapTwo;

    public void run() {
        setUp();
        while (!isOver) {
            printWorld();
            move();
        }
        printWorld();
    }

    private void setUp() {
        System.out.print("What is the name of your hero?: ");
        String name = console.nextLine();
        System.out.println("What is the Symbol of your hero, only one character please?");
        String newSymbol = console.nextLine();
        char c = newSymbol.charAt(0);


        Random rand = new Random();
        int x = rand.nextInt(WIDTH);
        int y = rand.nextInt(WIDTH);
        rand.nextInt(WIDTH);
        int a;
        rand.nextInt(WIDTH);
        int b;
        rand.nextInt(WIDTH);
        int e;
        rand.nextInt(WIDTH);
        int f;

        hero = new Hero(name,c, x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY());

        treasure = new Treasure(x, y);

        do{
            a= rand.nextInt(WIDTH);
            b=rand.nextInt(WIDTH);
        } while (a==hero.getX() && b == hero.getY());
        trap = new Trap(a,b);
        do{
            e= rand.nextInt(WIDTH);
            f =rand.nextInt(WIDTH);
        } while(e==hero.getX() && f == hero.getY());
        trapTwo=new Trap(e, f);
    }

    private void printWorld() {
        // top wall border
        System.out.println(WALL_CHARACTER.repeat(WIDTH + 2));

        for (int row = 0; row < WIDTH; row++) {
            // left wall border
            System.out.print(WALL_CHARACTER);
            for (int col = 0; col < WIDTH; col++) {
                if (row == hero.getY() && col == hero.getX()) {
                    System.out.print(hero.getSymbol());
                } else if (row == treasure.getY() && col == treasure.getX()) {
                    System.out.print("T");
                } else if(row == trap.getTrapA() && col == trap.getTrapB()){
                    System.out.print("X");
                } else if(row == trapTwo.getTrapA() && col == trapTwo.getTrapB()) {
                    System.out.print("X");
                }else {
                    System.out.print(EMPTY_CHARACTER);
                }
            }

            // right wall border
            System.out.println(WALL_CHARACTER);
        }

        // bottom wall border
        System.out.println(WALL_CHARACTER.repeat(WIDTH + 2));
    }

    private void move() {

        System.out.print(hero.getName() + ", move [WASD]: ");
        String move = console.nextLine().trim().toUpperCase();

        if (move.length() != 1) {
            return;
        }

        switch (move.charAt(0)) {
            case 'W':
                hero.moveUp();
                break;
            case 'A':
                hero.moveLeft();
                break;
            case 'S':
                hero.moveDown();
                break;
            case 'D':
                hero.moveRight();
                break;
        }

        if (hero.getX() < 0 || hero.getX() >= WIDTH
                || hero.getY() < 0 || hero.getY() >= WIDTH) {
            System.out.println(hero.getName() + " touched lava! You lose.");
            isOver = true;
        } else if (hero.getX() == treasure.getX() && hero.getY() == treasure.getY()) {
            System.out.println(hero.getName() + " found the treasure! You win.");
            isOver = true;
        } else if (hero.getX() == trap.getTrapA() && hero.getY() == trap.getTrapB()){
            System.out.println("You died!");
            isOver=true;
        } else if (hero.getX() == trapTwo.getTrapA() && hero.getY() == trapTwo.getTrapB()){
            System.out.println("You died!");
            isOver=true;
        }
    }
}
