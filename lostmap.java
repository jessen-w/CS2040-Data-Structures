import java.io.*;
import java.util.*;

public class lostmap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // Read the adjacency matrix
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        // Convert the adjacency matrix to the EdgeList format
        ArrayList<IntegerTriple> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edgeList.add(new IntegerTriple(adjacencyMatrix[i][j], i, j));
                }
            }
        }

        // sort by edge weight O(E log E)
        Collections.sort(edgeList);

        // THE SECOND PART, THE MAIN LOOP OF KRUSKAL'S ALGORITHM
        UnionFind uf = new UnionFind(n); // all V are disjoint sets at the beginning
        for (IntegerTriple e : edgeList) { // process all edges, O(E)
            int u = e.second(), v = e.third(); // note that we have re-ordered the integer triple
            if (!uf.isSameSet(u, v)) { // if no cycle
                bw.write((u + 1) + " " + (v + 1) + "\n");
                uf.unionSet(u, v); // link these two vertices
            }
        }

        br.close();
        bw.close();
    }
}


    class IntegerTriple implements Comparable<IntegerTriple> {
    public Integer _first, _second, _third;

    public IntegerTriple(Integer f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(IntegerTriple o) {
        if (!this.first().equals(o.first()))
        return this.first() - o.first();
        else if (!this.second().equals(o.second()))
        return this.second() - o.second();
        else
        return this.third() - o.third();
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }

    public String toString() { return first() + " " + second() + " " + third(); }
    }



    // Union-Find Disjoint Sets Library, using both path compression and union by rank heuristics
    class UnionFind {
    public int[] p;
    public int[] rank;
    public int[] setSize;
    public int numSets;

    public UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        setSize = new int[N];
        numSets = N;
        for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
        setSize[i] = 1;
        }
    }

    public int findSet(int i) { 
        if (p[i] == i) return i;
        else {
        p[i] = findSet(p[i]);
        return p[i]; 
        } 
    }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) { 
        if (!isSameSet(i, j)) { 
        numSets--; 
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) { 
            p[y] = x; 
            setSize[x] = setSize[x] + setSize[y]; 
        }
        else { 
            p[x] = y; 
            setSize[y] = setSize[x] + setSize[y];
            if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
        } 
    }

    public int numDisjointSets() { return numSets; }

    public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}
