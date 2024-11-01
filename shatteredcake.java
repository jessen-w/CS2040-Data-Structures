import java.util.*;

public class shatteredcake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int width = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        int totalArea = 0;
        
        for (int i = 0; i < n; i++){
            int w = sc.nextInt();
            int l = sc.nextInt();
            totalArea += w * l;
        }
        
        int length = totalArea / width; 
        System.out.println(length);
        sc.close();
    }
}
