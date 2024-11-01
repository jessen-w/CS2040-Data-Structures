import java.util.*;

public class humancanonball {
    public static final double INF = 1e9;
    public static ArrayList<ArrayList<doublePair>> AdjList = new ArrayList<ArrayList<doublePair>>();
    public static ArrayList<Double> D = new ArrayList<Double>();
    public static ArrayList<Double> p = new ArrayList<Double>();
    public static int V, E, n; // Declare 'n' at the class level

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double startX = sc.nextDouble();
        double startY = sc.nextDouble();
        double endX = sc.nextDouble();
        double endY = sc.nextDouble();
        n = sc.nextInt(); // Assign the value to the class-level variable 'n'

        Double[] cannonX = new Double[n+1];
        Double[] cannonY = new Double[n+1];
        for (int i = 1; i <= n; i ++) {
            cannonX[i] = sc.nextDouble();
            cannonY[i] = sc.nextDouble();
        }
        sc.close();

        AdjList.clear();
        for (int i = 0; i < n + 2; i++) {
            ArrayList<doublePair> Neighbor = new ArrayList<doublePair>();
            AdjList.add(Neighbor); // add neighbor list to Adjacency List
        }

        // source to sink
        int source = 0, sink = n + 1;
        double w = runTime(startX, startY, endX, endY);
        AdjList.get(source).add(new doublePair(sink, w));

        // source to cannons
        for (int i = 1; i <= n; i++) {
            int u = 0, v = i;
            double x = cannonX[i];
            double y = cannonY[i];
            double time = runTime(startX, startY, x, y);
            AdjList.get(u).add(new doublePair(v, time));
        }

        //cannons to cannons and sink
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    double xi = cannonX[i];
                    double yi = cannonY[i];
                    double xj = cannonX[j];
                    double yj = cannonY[j];
                    double time = cannonTime(xi, yi, xj, yj);
                    AdjList.get(i).add(new doublePair(j, time));
                }
            }
            double xi = cannonX[i];
            double yi = cannonY[i];
            double sinkTime = cannonTime(xi,yi, endX, endY);
            AdjList.get(i).add(new doublePair(sink, sinkTime));
        }

        initSSSP(source);

        // Bellman Ford's routine, implemented using AdjList
        for (int i = 0; i < n + 2 - 1; i++)
            for (int u = 0; u < n + 2; u++)
                for (int j = 0; j < AdjList.get(u).size(); j++) {
                    doublePair v = AdjList.get(u).get(j);
                    relax(u, (int) v.first(), v.second());
                }
        System.out.print(D.get(sink));
    }


    public static double runTime(double x1, double y1, double x2, double y2) {
        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);
        return Math.hypot(ac, cb) / 5;
    }

    public static double cannonTime(double x1, double y1, double x2, double y2) {
        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);
        double distance = Math.hypot(ac, cb) - 50;
        double cannon = (Math.abs(distance) / 5) + 2;
        double run = Math.hypot(ac, cb) / 5;
        if (cannon < run){
            return cannon;
        } else {
            return run;
        }
    }

    public static void initSSSP(int s) {
        D.clear();
        D.addAll(Collections.nCopies(n+2, INF));
        p.clear();
        p.addAll(Collections.nCopies(n+2, -1.0));
        D.set(s, 0.0);
    }

    public static void relax(int u, int v, double w_u_v) {
        if (D.get(u) != INF && D.get(v) > D.get(u) + w_u_v) {
            D.set(v, D.get(u) + w_u_v);
            p.set(v, (double) u);
        }
    }

    public static void backtrack(int s, int u) {
        if (u == -1 || u == s) {
            System.out.printf("%f", (double) u);
            return;
        }
        backtrack(s, p.get(u).intValue());
        System.out.printf(" %f", (double) u);
    }
}

class doublePair implements Comparable<doublePair> {
    double _first, _second;

    public doublePair(double f, double s) {
        _first = f;
        _second = s;
    }

    public int compareTo(doublePair o) {
        return Double.compare(this.first(), o.first());
    }

    double first() {
        return _first;
    }

    double second() {
        return _second;
    }
}
