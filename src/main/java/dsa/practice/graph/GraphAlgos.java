package dsa.practice.graph;

public class GraphAlgos {
    private boolean dfs(int[][] grid2, boolean[][] visited, int[][] grid1, int i, int j, int n, int m) {
        if (i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid2[i][j] == 0) {
            return true;
        }
        visited[i][j] = true;
        boolean status = true;
        status = dfs(grid2, visited, grid1, i, j+1, n, m) && status;
        status = dfs(grid2, visited, grid1, i-1, j, n, m) && status;
        status = dfs(grid2, visited, grid1, i, j-1, n, m) && status;
        status = dfs(grid2, visited, grid1, i+1, j, n, m) && status;
        status = (grid1[i][j] == 1) && status;
        return status;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        int m = grid2[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    if (dfs(grid2, visited, grid1, i, j, n, m)) {
                        ans++;
                    }

                }
            }
        }
        return ans;
    }
}
