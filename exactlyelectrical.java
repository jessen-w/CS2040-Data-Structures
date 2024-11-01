import java.util.*;

public class exactlyelectrical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        sc.nextLine();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        sc.nextLine();
        int power = sc.nextInt();
        int distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        if (power < distance){
            System.out.println("N");
        } else if ((power - distance) % 2 == 0){
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        sc.close();
    }
}
