import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class WarmUp619 {

    public static void main(String[] args) {
//        File file = new File ("secret-message.data");
//        try{
//            if(file.createNewFile()){
//                System.out.println("secret-message.data created");
//            } else {
//                System.out.println("secret-message.data already exists");
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What is the secret message?");
//        String input = scanner.nextLine();
//        printMessageToFile(input);
//        String[] messages = {"Not the message: 1", "Not the message: Test 2", "This is not the message try again", "CodeNameKidsNextDoor"};
//        printMessageToFile(messages);
//        System.out.println("File:");
        try (FileReader fileReader = new FileReader("secret-message.data");
             BufferedReader reader = new BufferedReader(fileReader)) {

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void printMessageToFile(String[] inputs){




        Random randMsg = new Random();
        String randMsgs = inputs[randMsg.nextInt(inputs.length)];
        try(FileWriter fileWriter = new FileWriter("secret-message.data", true);
            PrintWriter writer = new PrintWriter(fileWriter)){
            writer.println(randMsgs);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

}

