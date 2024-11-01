import java.util.*;

public class skener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int r = sc.nextInt();
        sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();
        for (int i = 0; i <= r; i++){
            String temp = sc.nextLine();
            char[] row = temp.toCharArray();
            String finale = "";
            for (int j = 0; j <= row.length - 1; j++){
                for (int k = 1; k <= zc; k++) {
                    finale += row[j];
                }
            }
            for (int l = 1; l <= zr; l++){
                System.out.println(finale);
            }
        }
        sc.close();
    }
}