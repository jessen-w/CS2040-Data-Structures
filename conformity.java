import java.util.*;

public class conformity {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        HashMap<String, Integer> courseMap = new HashMap<>();
        int maxCount = 0; 
        ArrayList<String> courses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] numbers = new int[5];
            for (int j = 0; j < 5; j++) {
                numbers[j] = io.getInt();
            }
            Arrays.sort(numbers);

            StringBuilder sortedString = new StringBuilder();
            for (int k = 0; k < 5; k++) {
                sortedString.append(numbers[k]);
            }

            int frequency = courseMap.getOrDefault(sortedString.toString(), 0) + 1;
            courseMap.put(sortedString.toString(), frequency);

            if (frequency > maxCount){
                maxCount = frequency;
                courses.clear();
                courses.add(sortedString.toString());
            } else if (frequency == maxCount){
                courses.add(sortedString.toString());
            }
        }
        
        int counter = 0;
        for (String course : courses) {
            counter += courseMap.get(course);
        }

        io.print(counter);
        io.close();
    }
}
