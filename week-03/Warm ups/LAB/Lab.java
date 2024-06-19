package LAB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Lab {

    public static void main(String[] args) {
        File file = new File ("secret-message.data");
        try{
            if(file.createNewFile()){
                System.out.println("secret-message.data created");
            } else {
                System.out.println("secret-message.data already exists");
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the secret message?");
        String input = scanner.nextLine();


    }

    public String printMessageToFile(String input){
        try(FileWriter fileWriter = new FileWriter("secret-message.data", true);
            PrintWriter writer = new PrintWriter(fileWriter)){
            writer.println(input);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return "Message Uploaded";

    }

}
