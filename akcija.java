import java.util.*;

public class akcija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        int total = 0;
        for (int j = n - 1, count = 0; j >= 0; j--) {
            if (count < 2) {
                total += array[j];
                count++;
            } else {
                count = 0;
            }
        }

        System.out.println(total);
        sc.close();
    }
}
