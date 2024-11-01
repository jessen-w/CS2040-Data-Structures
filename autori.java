import java.util.*;

public class autori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String name = sc.next();
        String[] nameSplit = name.split("-");
        for (String str : nameSplit){
            System.out.print(str.charAt(0));
        }
        sc.close();
    }
}
