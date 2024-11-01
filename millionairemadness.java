import java.util.*;

public class millionairemadness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(shortestPath(matrix));
        sc.close();
    }
    static class Node {
        int x;
        int y;
        int edge;

        Node(int x, int y, int edge) {
            this.x = x;
            this.y = y;
            this.edge = edge;
        }
    }

    static int shortestPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node a) -> {
            if (a.edge < 0) {
                return Math.abs(a.edge);
            } else {
                return a.edge;
            }
        }));

        boolean[][] visited = new boolean[m][n];
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            int edge = curr.edge;

            if (x == m - 1 && y == n - 1) {
                return Math.abs(edge);
            }

            visited[x][y] = true;

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int diff = matrix[newX][newY] - matrix[x][y];
                    int newEdge = Math.max(edge, diff);
                    queue.add(new Node(newX, newY, newEdge));
                }
            }
        }

        return 0;
    }
}