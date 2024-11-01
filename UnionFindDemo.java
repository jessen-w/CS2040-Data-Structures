import java.util.*;

public class UnionFindDemo {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int m = io.getInt();

        UnionFind ufds = new UnionFind(n);

        for (int i = 0; i < m; i++){
            int command = io.getInt();
            if (command == 1){
                int p = io.getInt();
                int q = io.getInt();
                ufds.unionSet(p, q);
            } else if (command == 2){
                int p = io.getInt();
                int q = io.getInt();
                ufds.moveSet(p, q);
            } else{
                int p = io.getInt();
                ufds.findSet(p);
            }
        }
        io.close();
    }
}

class UnionFind {                                              
  public int[] p;
  public int[] rank;

  public UnionFind(int N) {
    p = new int[N+1];
    rank = new int[N+1];
    for (int i = 1; i < N+1; i++) {
      p[i] = i;
      rank[i] = 1;
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
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) 
      	p[y] = x;
      else { 
      	p[x] = y;
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public void moveSet(int i, int j) {
    if (!isSameSet(i, j)) { 
      int x = findSet(i), y = findSet(j);
      p[x] = y;
      if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
    }
  }
}
