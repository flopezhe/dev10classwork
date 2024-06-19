import java.util.HashMap;

public class WarmUp618 {
    public static void main(String[] args) {

//        HashMap<Integer,Character> ceaserCipherMapTwo = new HashMap<>();
//        ceaserCipherMapTwo.put(1, 'H');
//        ceaserCipherMapTwo.put(2, 'E');
//        ceaserCipherMapTwo.put(3, 'L');
//        ceaserCipherMapTwo.put(4, 'L');
//        ceaserCipherMapTwo.put(5, 'O');
//        ceaserCipherMapTwo.put(6, ',');
//        ceaserCipherMapTwo.put(7, ' ');
//        ceaserCipherMapTwo.put(8, 'W');
//        ceaserCipherMapTwo.put(9, 'O');
//        ceaserCipherMapTwo.put(10, 'R');
//        ceaserCipherMapTwo.put(11, 'L');
//        ceaserCipherMapTwo.put(12, 'D');
//        ceaserCipherMapTwo.put(13, '.');
////        System.out.println(ceaserCipherMapTwo);
//
//        HashMap<Integer,Character> ceaserCipherMap = new HashMap<>();
//        ceaserCipherMap.put(1, 'H');
//        ceaserCipherMap.put(2, 'E');
//        ceaserCipherMap.put(3, 'L');
//        ceaserCipherMap.put(4, 'L');
//        ceaserCipherMap.put(5, 'O');
//        ceaserCipherMap.put(6, ',');
//        ceaserCipherMap.put(7, ' ');
//        ceaserCipherMap.put(8, 'W');
//        ceaserCipherMap.put(9, 'O');
//        ceaserCipherMap.put(10, 'R');
//        ceaserCipherMap.put(11, 'L');
//        ceaserCipherMap.put(12, 'D');
//        ceaserCipherMap.put(13, '.');
////        System.out.println(ceaserCipherMap);
//
//        for (Character value : ceaserCipherMap.values()) {
//            Character valuesOfMap = ceaserCipherMap.get(value);
//            ceaserCipherMapTwo.values().addAll(ceaserCipherMap.values());
//        }

        String text = "Tu Rmdup, U ftuzw U zqqp m zqi oaybgfqd... xax";

        for (int shift = 1; shift <= 26; shift++) {
            for (char c : text.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    char a = Character.isUpperCase(c) ? 'A' : 'a';
                    System.out.print((char) ((c - a + shift) % 26 + a));
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();

        }
    }
}
