import java.util.*;

public class peasoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine();
        int checks = 0;

        for (int i = 1; i <= n; i++){
            int nmenu = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            boolean check1 = false;
            boolean check2 = false;
            for (int j = 1; j <= nmenu; j++){
                String temp = sc.nextLine();
                if (temp.equals("pea soup")){
                    check1 = true;
                }
                if (temp.equals("pancakes")){
                    check2 = true;
                }
            }
            if ((check1 == true) && (check2 == true)){
                System.out.println(name);
                checks++;
                break;
            }  
        }
        if (checks == 0){
            System.out.println("Anywhere is fine I guess");
        }
        sc.close();
    }
}