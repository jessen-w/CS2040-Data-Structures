import java.util.*;

public class kattissquest {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();

        TreeMap<Long, PriorityQueue<Long>> tm = new TreeMap<>();

        for (int i = 0; i < n; i++){
            String command = io.getWord();
            if (command.equals("add")){
                long energy = io.getLong();
                long gold = io.getLong();
                if (!tm.containsKey(energy)) {
                    tm.put(energy, new PriorityQueue<>(Comparator.reverseOrder()));
                }
                tm.get(energy).add(gold);
            } else{
                long x = io.getLong();
                long total = 0;
                while (true){
                    Long energyUsed = tm.floorKey(x);
                    if (energyUsed == null){
                        break;
                    }
                    PriorityQueue<Long> currentQueue = tm.get(energyUsed);
                    if (currentQueue.isEmpty()) {
                        tm.remove(energyUsed);
                        continue;
                    }
                    Long current = currentQueue.poll();
                    if (current != null) {
                        x -= energyUsed;
                        total += current;
                    }
                }
                io.println(total);
            }
        }
        io.close();
    }
}
