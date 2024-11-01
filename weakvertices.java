import java.util.*;

public class weakvertices {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (true){
            int n = io.getInt();
            if (n == -1){
                break;
            }

            HashMap<Integer, List<Integer>> hm = new HashMap<Integer,List<Integer>>();
            int[][] adjMatrix = new int[n][n];

            for (int i = 0; i < n; i++){
                List<Integer> connectedVertices = new ArrayList<>();
                for (int j = 0; j < n; j++){
                    int w = io.getInt();
                    adjMatrix[i][j] = w;
                    if (w == 1){
                        connectedVertices.add(j);
                    }
                }
                hm.put(i, connectedVertices);
            }

            for (int i = 0; i < n; i++){
                List<Integer> verticeList = new ArrayList<>();
                verticeList = hm.get(i);
                int count = 0;
                for (int j = 0; j < verticeList.size(); j++) {
                    for (int k = 0; k < verticeList.size(); k++) {
                        int first = verticeList.get(j);
                        int second = verticeList.get(k);
                        if (adjMatrix[first][second] == 1){
                            count += 1;
                        }
                    }
                }
                if (count < 2){
                    System.out.print(i + " ");
                }

            }
            System.out.println();
        }
        io.close();
    }
}
    
        