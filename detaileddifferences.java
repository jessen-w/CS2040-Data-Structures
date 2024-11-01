import java.util.*;

public class detaileddifferences{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++){
            String first = sc.nextLine();
            String second = sc.nextLine();
            int length = first.length();
            System.out.println(first);
            System.out.println(second);
            for (int j = 1; j <= length; j++){
                if (first.charAt(j-1) == second.charAt(j-1)){
                    System.out.print(".");
                } else{
                    System.out.print("*");
                }
            }
            System.out.println("\n");
        }
        sc.close();
    }
}