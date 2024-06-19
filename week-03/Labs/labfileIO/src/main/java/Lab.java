import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Lab {
    public static void main(String[] args) {
//        System.out.println("File:");
//        try (FileReader fileReader = new FileReader("README.txt");
//             BufferedReader reader = new BufferedReader(fileReader)) {
//
//            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//                System.out.println(line);
//            }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//CREATING ELEMENTS.DATA
//        File file = new File ("elements.data");
//        try{
//            if(file.createNewFile()){
//                System.out.println("elements.data created");
//            } else {
//                System.out.println("elements.data already exists");
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
        // CREATING SUPERBADFILE
//        File file = new File("super-bad-file.java");
//        try{
//            if (file.createNewFile()){
//                System.out.println("super-bad-file.java created");
//            } else{
//                System.out.println("superbadfile already exists");
//            }
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }

//        try(FileWriter fileWriter = new FileWriter("elements.data", true);
//            PrintWriter writer = new PrintWriter(fileWriter)){
//            writer.println("hydrogen");
//            writer.println("helium");
//            writer.println("lithium");
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }
//


//        File file = new File("super-bad-file.java");
//        boolean success = file.delete();
//        if(success){
//            System.out.println("super-bad-file.java was deleted");
//        } else {
//            System.out.println("superbadfile was not deleted");
//        }


        // THIS IS WHERE WE DID THE COPY
                ArrayList<String> oldFileTextElements = new ArrayList<>();
                System.out.println("Elements File:");
        try(FileReader fileReader = new FileReader("elements.data");
            BufferedReader reader = new BufferedReader(fileReader) ){
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
                oldFileTextElements.add(line);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
//
//        File file = new File("new-elements.data");
//        try{
//            if(file.createNewFile()){
//                System.out.println("new-elements.data created");
//            } else {
//                System.out.println("new-elements.data already exists");
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//
        try(FileWriter fileWriter = new FileWriter("new-elements.data", true);
            PrintWriter writer = new PrintWriter(fileWriter)){
            writer.println(oldFileTextElements);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("File:");
        try (FileReader fileReader = new FileReader("new-elements.data");
             BufferedReader reader = new BufferedReader(fileReader)) {

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
