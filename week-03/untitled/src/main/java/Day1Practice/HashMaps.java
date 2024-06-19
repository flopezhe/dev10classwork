package Day1Practice;

import java.util.HashMap;

public class HashMaps {

    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("Maria", 102395);
        empIds.put("Farid", 192483);
        empIds.put("Forest", 92481);

        System.out.println(empIds);
        System.out.println(empIds.get("Forest"));
    }


}
