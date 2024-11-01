import java.util.*;

public class sumkindofproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            int label = sc.nextInt();
            int k = sc.nextInt();
            int s1 = k * (k + 1) / 2;          
            int s2 = k * k;              
            int s3 = k * (k + 1); 
            System.out.println(label + " " + s1 + " " + s2 + " " + s3);
        }
        sc.close();
    }
}
