import java.util.Scanner;

public class WarmUp606 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

//        System.out.println("Select rock paper or scissors:");
//        String playerMove = console.nextLine();
//        String playerSelection = playerMove.toLowerCase();
//        int computerMove = (int)(Math.random()*3)+1;
//
//                if (computerMove== 1){
//                    System.out.println("rock");
//                } else if (computerMove==2){
//                    System.out.println("paper");
//                } else if (computerMove==3){
//                    System.out.println("scissors");
//                }
//
//                if(playerSelection.equalsIgnoreCase() && computerMove==1 || computerMove==2 || computerMove ==3){
//                    System.out.println("you lose no matter what");
//                } else {
//                    System.out.println("wrong move");
//                    }
//                }
        System.out.println("Enter a whole number");
        int playerSelection = Integer.parseInt(console.nextLine());

        if(playerSelection%2==0){

            System.out.println("Even number");
        } else {
            System.out.println("not an even number");
        }

    }
    }

