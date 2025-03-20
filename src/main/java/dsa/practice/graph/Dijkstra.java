package dsa.practice.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    int[][] children = new int[][]{{1, 0, 3}, {0, 1, 1}, {-1, 0, 4}, {0, -1, 2}};
    private boolean isValid(boolean[][] visited , int m, int n, int i, int j) {
        return i>=0 && j>=0 && i<m && j<n && !visited[i][j];
    }
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int dist = top[0];
            int x = top[1];
            int y = top[2];
            visited[x][y]= true;
            if (x == m-1 && y == n-1) {
                return dist;
            }
            int curDir = grid[x][y];
            for (int[] c: children) {
                int i = x + c[0];
                int j = y + c[1];
                if (isValid(visited, m, n, i, j)) {
                    if (curDir == c[2]) {
                        pq.offer(new int[]{dist, i, j});
                    } else {
                        pq.offer(new int[]{dist + 1, i, j});
                    }
                }
            }
        }
        return -1;
    }
}
