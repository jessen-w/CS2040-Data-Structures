import java.util.*;

public class lastfactorialdigit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++){
            int num = sc.nextInt();
            int j,fact=1;
            for (j = 1; j <= num; j++){
                fact=fact*j;
            }
            int digit = fact % 10;
            System.out.println(digit);
            sc.nextLine();
        }
        sc.close();
    }
}