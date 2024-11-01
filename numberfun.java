import java.util.*;

public class numberfun{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++){
            float num1 = sc.nextInt();
            float num2 = sc.nextInt();
            float result = sc.nextInt();
            if(num1 + num2 == result || num1 * num2 == result || num1 - num2 == result || num2 - num1 == result || num1/num2 == result || num2/num1 == result){
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
            sc.nextLine();
        }
        sc.close();
    }
}