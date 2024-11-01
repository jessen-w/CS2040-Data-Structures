/*import java.util.*;

public class sortofsorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
            while (n != 0){
                sc.nextLine();
                String[] array = new String[n];
                for (int i = 0; i < n; i++){
                    array[i] = sc.nextLine();
                }
                Arrays.sort(array, (str1, str2) -> str1.charAt(0) - str2.charAt(0));
                Arrays.sort(array, (str1, str2) -> str1.charAt(1) - str2.charAt(1));
                Arrays.asList(array).forEach(System.out::println);
                System.out.println();
                n = sc.nextInt();
            }
        sc.close();
    }
}*/

import java.util.*;

public class sortofsorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
            while (n != 0){
                sc.nextLine();
                String[] array = new String[n];
                for (int i = 0; i < n; i++){
                    array[i] = sc.nextLine();
                }
                int N = 2; // sort by first 2 chars
                String[] result = Arrays.stream(array)
                    .sorted(Comparator.comparing(s -> s.substring(0, N)))
                    .toArray(String[]::new);
                Arrays.asList(result).forEach(System.out::println);
                System.out.println();
                n = sc.nextInt();
            }   
        sc.close();
    }
}