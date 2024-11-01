public class almostunionfind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        while (io.hasMoreTokens()){
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
                    ufds.returnSet(p);
                }
            }
        }
        io.close();
    }
}

class UnionFind {
    public int[] p;
    public int[] count;
    public long[] sum;
    public int[] ultP;

    public UnionFind(int N) {
        p = new int[N + 1];
        count = new int[N + 1];
        sum = new long[N + 1];
        ultP = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            count[i] = 1;
            sum[i] = i;
            ultP[i] = i;
        }
    }

    public int findSet(int i) {
        int nextP = ultP[i];
        while (nextP != p[nextP]) {
            nextP = p[nextP];
        }
        ultP[i] = nextP;
        return nextP;
    }


    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) { 
        if (!isSameSet(i, j)) { 
            int x = findSet(i), y = findSet(j);
            p[x] = y;
            ultP[i] = y;
            count[y] += count[x];
            sum[y] += sum[x];
        } 
    }

    public void moveSet(int i, int j) {
        if (!isSameSet(i, j)) { 
            int x = findSet(i), y = findSet(j);
            ultP[i] = y;
            count[y] += 1;
            sum[y] += i;
            count[x] -= 1;
            sum[x] -= i;
        }
    }

    public void returnSet(int i) { 
        int x = findSet(i);
        System.out.println(count[x] + " " + sum[x]);
    }
}


