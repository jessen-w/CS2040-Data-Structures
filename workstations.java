import java.util.*;

public class workstations {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in, System.out);
        int n = sc.getInt();
        int m = sc.getInt();
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        PriorityQueue<Integer> current = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int a = sc.getInt();
            int s = sc.getInt();
            if (!hm.containsKey(a)) {
                hm.put(a, new PriorityQueue<>());
            }
            hm.get(a).add(a + s);
            pq.add(a);
        }
        int count = 0;
        current.add(hm.get(pq.poll()).poll());
        while (!pq.isEmpty()) {
            if(pq.peek() <= current.peek() + m && pq.peek() >= current.peek()) {
                current.poll();
                current.add(hm.get(pq.poll()).poll());
                count++;
            } else if (pq.peek() < current.peek()) {
                current.add(hm.get(pq.poll()).poll());
            } else{
                if (current.size() > 1) {
                    boolean added = false;
                    Stack<Integer> stack = new Stack<>();
                    while (current.size() > 1) {
                        int peeked = pq.peek();
                        if (peeked <= current.peek() + m && peeked >= current.peek()) {
                            current.poll();
                            current.add(hm.get(pq.poll()).poll());
                            count++;
                            added = true;
                            break;
                        } else {
                            stack.push(current.poll());
                        }
                    }
                    if (!added) {
                        while (!stack.isEmpty()) {
                            current.add(stack.pop());
                        }
                        current.poll();
                        current.add(hm.get(pq.poll()).poll());
                    }
                } else {
                    current.poll();
                    current.add(hm.get(pq.poll()).poll());
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
