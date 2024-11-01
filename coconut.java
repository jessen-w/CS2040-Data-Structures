import java.util.*;

public class coconut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int[] array = new int[n * 2];

        for (int i = 0; i < n; i++) {
            array[i * 2] = 3;
            array[i * 2 + 1] = 0;
        }

        int pointer = 0;

        while (countUnfoldedPlayers(array) > 1) {
            int counter = 0;
            while (counter != s){
                pointer = pointer % (n*2);
                if (array[pointer] != 0) {
                    counter += 1;
                    pointer += 1;
                } else{
                    pointer += 1;
                }
            }
            pointer -= 1;
            pointer = pointer % (n*2);

            if (array[pointer] == 3) { 
                array[pointer] = 2;
                array[(pointer + 1) % (n*2)] = 2;
            } else if (array[pointer] == 2) {
                array[pointer] = 1;
                pointer += 1;
                pointer = pointer % (n*2);
            } else if (array[pointer] == 1) {
                array[pointer] = 0;
                pointer += 1;
                pointer = pointer % (n*2);
            } else{
                pointer += 1;
                pointer = pointer % (n*2);
            }
        }
        int player = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                player = i;
                break; 
            }
        }
        System.out.println((player / 2) + 1);
    }

    public static int countUnfoldedPlayers(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i != 0) {
                count++;
            }
        }
        return count;
    }
}
