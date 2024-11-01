// Name: Jareth Lee Kae Xun
// Student No: A0251825E

import java.io.*;
import java.util.*;

public class Dominos { // count number of SCCs
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int cases = Integer.parseInt(br.readLine());
        while (cases-- > 0) {
            String[] init = br.readLine().split(" ");
            int n = Integer.parseInt(init[0]); // num of dominos (vertices)
            int m = Integer.parseInt(init[1]); // num of lines (edges)

            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>()); // init new AL for each domino
                visited[i] = false;
            }

            while (m-- > 0) {
                String[] line = br.readLine().split(" ");
                int parent = Integer.parseInt(line[0]) - 1;
                int child = Integer.parseInt(line[1]) - 1;
                adjList.get(parent).add(child);
            }

            int SCC = Kosaraju(adjList, visited);
            pw.println(SCC);
        }
        br.close();
        pw.close();
    }

    static void toposortDFS(int source, ArrayList<ArrayList<Integer>> adjList,
                            boolean[] visited, Stack<Integer> toposort) {
        visited[source] = true;
        for (int i = 0; i < adjList.get(source).size(); i++) {
            int next = adjList.get(source).get(i);
            if (!visited[next]) {
                toposortDFS(next, adjList, visited, toposort);
            }
        }
        toposort.push(source);
    }

    static void DFS(int source, ArrayList<ArrayList<Integer>> adjList,
                    boolean[] visited) {
        visited[source] = true;
        for (int i = 0; i < adjList.get(source).size(); i++) {
            int next = adjList.get(source).get(i);
            if (!visited[next]) {
                DFS(next, adjList, visited);
            }
        }
    }

    static int Kosaraju(ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        // obtain toposort order of G
        Stack<Integer> toposort = new Stack<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                toposortDFS(i, adjList, visited, toposort);
            }
        }

        int SCC = 0;
        boolean[] transposedVisited = new boolean[adjList.size()];
        while (!toposort.isEmpty()) {
            int next = toposort.pop();
            if (!transposedVisited[next]) {
                SCC++;
                DFS(next, adjList, transposedVisited);
            }
        }
        return SCC;
    }
}