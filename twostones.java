import java.util.*;

public class twostones{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        if (n%2==0){
            System.out.print("Bob");
        } else {
            System.out.print("Alice");
        }
        sc.close();
    }
}