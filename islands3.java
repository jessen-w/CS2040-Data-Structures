import java.util.*;

public class islands3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = word.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] != 'W') {
                    if (bfs(grid, visited, i, j, n, m)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean bfs(char[][] grid, boolean[][] visited, int row, int col, int n, int m) {
        int[] rowOffset = {-1, 1, 0, 0};
        int[] colOffset = {0, 0, -1, 1};
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(row * m + col);
        visited[row][col] = true;
        boolean isLand = false;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int r = u / m;
            int c = u % m;
            if (grid[r][c] == 'L') {
                isLand = true;
            }
            for (int k = 0; k < 4; k++) {
                int newRow = r + rowOffset[k];
                int newCol = c + colOffset[k];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && grid[newRow][newCol] != 'W') {
                    visited[newRow][newCol] = true;
                    queue.offer(newRow * m + newCol);
                }
            }
        }
        return isLand;
    }
}
