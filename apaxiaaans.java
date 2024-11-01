import java.util.*;

public class apaxiaaans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String name = sc.nextLine();
        char [] charArray = name.toCharArray();
        List<Character> newArray = new ArrayList<>();
        for (int i = 0; i < charArray.length-1; i++) {
            if (charArray[i] != charArray[i+1]){
                newArray.add(charArray[i]);
            }
        }
        newArray.add(charArray[charArray.length - 1]);
        sc.close();
        for (char c : newArray) {
            System.out.print(c);
        }
    }
}
