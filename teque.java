import java.util.*;

public class teque {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        HashMap<Integer, Integer> frontMap = new HashMap<>();
        HashMap<Integer, Integer> backMap = new HashMap<>();
        int frontHead = 0;
        int frontTail = 1;
        int backHead = 0;
        int backTail = 1;

        for (int i = 0; i < n; i++) {
            String command = io.getWord();
            int number = io.getInt();
            if (command.equals("push_front")) {
                frontMap.put(frontHead, number);
                frontHead--;
            } else if (command.equals("push_back")) {
                backMap.put(backTail, number);
                backTail++;
            } else if (command.equals("push_middle")) {
                frontMap.put(frontTail, number);
                frontTail++;
            } else {
                if (number >= frontMap.size()){
                    io.println(backMap.get(backHead + number - frontMap.size() + 1));
                } else{
                    io.println(frontMap.get(frontHead + number + 1));
                }
            }

            if (frontMap.size() == backMap.size() + 2) {
                frontTail--;
                backMap.put(backHead, frontMap.get(frontTail));
                backHead--;
                frontMap.remove(frontTail);
            }
            if (frontMap.size() + 1 == backMap.size()){
                backHead++;
                frontMap.put(frontTail, backMap.get(backHead));
                frontTail++;
                backMap.remove(backHead);
            }
        }
        io.flush();
    }
}