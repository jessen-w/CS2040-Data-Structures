import java.util.*;

public class password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[] array = new float[n];
        float value = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            float number = Float.parseFloat(parts[1]);
            array[i] = number;
        }
        Arrays.sort(array);
        for (int j = 1; j <= n; j++){
            value += j * array[n-j];
        }
        System.out.format("%.4f", value);
        sc.close();
    }
}