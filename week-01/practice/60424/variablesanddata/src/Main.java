//public class Main {
//    public static void main(String[] args) {
//
////        boolean isBoolean = false;
////        boolean isHappy = true;
////        boolean isBooleanTotal = isBoolean > isHappy;
////        System.out.println(isBooleanTotal);
////        String name = "Bob";
////        boolean nameIsLong = name.length() > 6;
////        System.out.println(nameIsLong);
//
//    }
//}
//public class Main {
//    public static void main(String[] args){
//        // console is variable name, I can change it to anything, for example blahBlah
//        java.util.Scanner console = new java.util.Scanner(System.in);
//
//        System.out.println("Enter your name:");
//        //Below is where I call the above scanner, again it is just a variable name
//        String name = console.nextLine();
//        System.out.println("Your name is :"+name);
//    }
//}
public class Main {
    public static void main(String[] args){

        int place = 2;
        String ribbonColor ;

        switch(place){
            case 1:
                ribbonColor = "blue";
                System.out.println("first place!");
                break;
            case 2:
                ribbonColor = "red";
                System.out.println("second place!");
                break;
            case 3:
                ribbonColor = "white";
                System.out.println("third place!");
                break;
            default:
                ribbonColor = "unknown!";
        }

        System.out.println(ribbonColor);
    }
}