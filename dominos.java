import java.util.*;

public class dominos {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int tests = io.getInt();
        for (int t = 0; t < tests; t++) {
            int n = io.getInt();
            int m = io.getInt();
        
            graph = new ArrayList<>();
            visited = new boolean[n];
        
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                int u = io.getInt();
                int v = io.getInt();
                graph.get(u - 1).add(v - 1); 
            }

            Stack<Integer> stack = dfsToposort(graph, visited);
            int count = dfsCount(stack, n); 

            io.println(count);
        }
        io.close();
    }

    static Stack<Integer> dfsToposort(ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfsToposortUtil(i, visited, stack, graph);
            }
        }
        return stack;
    }

    static void dfsToposortUtil(int u, boolean[] visited, Stack<Integer> stacker, ArrayList<ArrayList<Integer>> graph) {
        visited[u] = true;
        for (int next : graph.get(u)) {
            if (!visited[next]) {
                dfsToposortUtil(next, visited, stacker, graph);
            }
        }
        stacker.push(u);
    }
    

    static int dfsCount(Stack<Integer> stack, int n) { 
        int SCC = 0;
        boolean[] transposed = new boolean[n];
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (!transposed[index]) {
                SCC++;
                DFS(index, graph, transposed);
            }
        }
        return SCC;
    }

    static void DFS(int u, ArrayList<ArrayList<Integer>> graph, boolean[] transposed) {
        transposed[u] = true;
        for (int next : graph.get(u)) {
            if (!transposed[next]) {
                DFS(next, graph, transposed);
            }
        }
    }
}
