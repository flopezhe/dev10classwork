import java.util.Arrays;
import java.util.Random;

public class Exercise10 {

    public static void main(String[] args) {
        String[] bugs = makeBugArray();

        // The bugs array elements are either the value "beetle" or "mosquito".
        // 1. Count the number of beetles and mosquitoes.
        // 2. Print the result.
        // Results will vary because of randomness.
        int mosquitoBugSum = 0;
        int beetleBugSum = 0;


        for(int bugsInArray = 0; bugsInArray < bugs.length ; bugsInArray++){
            if(bugs[bugsInArray].equals("mosquito")){
                mosquitoBugSum += 1;
            } else if (bugs[bugsInArray].equals("beetle")){
                beetleBugSum += 1;
            }
        }
        System.out.println("Mosquito count: "+mosquitoBugSum);
        System.out.println("Beetle count: " +beetleBugSum);
//        int totalBugSum = mosquitoBugSum + beetleBugSum;
//        System.out.println(totalBugSum);
    }

    public static String[] makeBugArray() {
        String[] bugs = new String[200];
        Arrays.fill(bugs, "beetle");
        Random random = new Random();
        for (int i = 0; i < random.nextInt(150); i++) {
            bugs[random.nextInt(bugs.length)] = "mosquito";
        }
        return bugs;
    }
}
