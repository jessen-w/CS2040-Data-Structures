import java.util.*;

public class pot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine();
        int result = 0;
        for (int i = 1; i <= n; i++){
            int raw = sc.nextInt();
            int power = raw % 10;
            int num = (raw-power)/10;
            int digit = (int) Math.pow(num,power);
            result += digit;
        }
        System.out.println(result);
        sc.close();
    }
}