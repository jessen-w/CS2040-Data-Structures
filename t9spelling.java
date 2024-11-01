// Name: Jessen Wiryawan | Matric: A0264698H
/*import java.util.*;

public class t9spelling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int loop = sc.nextInt();
        sc.nextLine();

        Map<Character, String> dictionary = new HashMap<>();
        dictionary.put('a', "2");
        dictionary.put('b', "22");
        dictionary.put('c', "222");
        dictionary.put('d', "3");
        dictionary.put('e', "33");
        dictionary.put('f', "333");
        dictionary.put('g', "4");
        dictionary.put('h', "44");
        dictionary.put('i', "444");
        dictionary.put('j', "5");
        dictionary.put('k', "55");
        dictionary.put('l', "555");
        dictionary.put('m', "6");
        dictionary.put('n', "66");
        dictionary.put('o', "666");
        dictionary.put('p', "7");
        dictionary.put('q', "77");
        dictionary.put('r', "777");
        dictionary.put('s', "7777");
        dictionary.put('t', "8");
        dictionary.put('u', "88");
        dictionary.put('v', "888");
        dictionary.put('w', "9");
        dictionary.put('x', "99");
        dictionary.put('y', "999");
        dictionary.put('z', "9999");
        dictionary.put(' ',"0");

        for (int i = 0; i < loop; i++){
            System.out.print("Case #");
            System.out.print(i+1);
            System.out.print(": ");
            String item = sc.nextLine();
            char [] charArray = item.toCharArray();
            for (int j = 0; j < charArray.length; j++){
                if (j < charArray.length - 1 && charArray[j] == charArray[j+1]){
                    System.out.print(dictionary.get(charArray[j]) + " ");
                } else if (j < charArray.length - 1 && dictionary.get(charArray[j]).contains(dictionary.get(charArray[j+1]))){
                    System.out.print(dictionary.get(charArray[j]) + " ");
                } else if (j < charArray.length - 1 && dictionary.get(charArray[j+1]).contains(dictionary.get(charArray[j]))){
                    System.out.print(dictionary.get(charArray[j]) + " ");
                } else{
                    System.out.print(dictionary.get(charArray[j]));
                }
            }
            System.out.println();
        }
        sc.close();
    }
} */

// Name: Jessen Wiryawan | Matric: A0264698H
import java.util.*;

public class t9spelling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        sc.nextLine();

        String[] dictionary = new String[256];
        Arrays.fill(dictionary, "");
        dictionary['a'] = "2";
        dictionary['b'] = "22";
        dictionary['c'] = "222";
        dictionary['d'] = "3";
        dictionary['e'] = "33";
        dictionary['f'] = "333";
        dictionary['g'] = "4";
        dictionary['h'] = "44";
        dictionary['i'] = "444";
        dictionary['j'] = "5";
        dictionary['k'] = "55";
        dictionary['l'] = "555";
        dictionary['m'] = "6";
        dictionary['n'] = "66";
        dictionary['o'] = "666";
        dictionary['p'] = "7";
        dictionary['q'] = "77";
        dictionary['r'] = "777";
        dictionary['s'] = "7777";
        dictionary['t'] = "8";
        dictionary['u'] = "88";
        dictionary['v'] = "888";
        dictionary['w'] = "9";
        dictionary['x'] = "99";
        dictionary['y'] = "999";
        dictionary['z'] = "9999";
        dictionary[' '] = "0";

        for (int i = 0; i < loop; i++) {
            System.out.print("Case #");
            System.out.print(i + 1);
            System.out.print(": ");
            String item = sc.nextLine();
            char[] charArray = item.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (j < charArray.length - 1 && charArray[j] == charArray[j + 1]) {
                    System.out.print(dictionary[charArray[j]] + " ");
                } else if (j < charArray.length - 1 && dictionary[charArray[j]].contains(dictionary[charArray[j + 1]])) {
                    System.out.print(dictionary[charArray[j]] + " ");
                } else if (j < charArray.length - 1 && dictionary[charArray[j + 1]].contains(dictionary[charArray[j]])) {
                    System.out.print(dictionary[charArray[j]] + " ");
                } else {
                    System.out.print(dictionary[charArray[j]]);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
