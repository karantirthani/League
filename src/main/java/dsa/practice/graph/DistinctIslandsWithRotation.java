package dsa.practice.graph;

import java.util.*;

public class DistinctIslandsWithRotation {
    private int[][] directions = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int numDistinctIslands2(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Set<String> result = new HashSet<>();
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] != 1) continue;
                List<Point> path = new ArrayList<>();
                dfs(grid, i, j, path, row, col);
                result.add(normalize(path));
            }
        }

        return result.size();
    }

    private String normalize(List<Point> path) {
        List<Point>[] allShape = new List[8];
        for (int i = 0; i < 4; i ++) {
            allShape[i] = new ArrayList<>();
            allShape[i + 4] = new ArrayList<>();
            for (Point p : path) {
                allShape[i].add(new Point(p.x * directions[i][0], p.y * directions[i][1]));
                allShape[i + 4].add(new Point(p.y * directions[i][1], p.x * directions[i][0]));
            }

            Collections.sort(allShape[i]);
            Collections.sort(allShape[i + 4]);
        }

        String[] result = new String[8];
        for (int i = 0; i < 8; i ++) {
            int x = allShape[i].get(0).x, y = allShape[i].get(0).y;
            StringBuilder sb = new StringBuilder();
            for (Point p : allShape[i]) {
                sb.append(p.x - x);
                sb.append(',');
                sb.append(p.y - y);
                sb.append('/');
            }
            result[i] = sb.toString();
        }
        Arrays.sort(result);
        return result[0];
    }

    private void dfs(int[][] grid, int i, int j, List<Point> path, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) return;
        grid[i][j] = 2;
        path.add(new Point(i, j));

        dfs(grid, i + 1, j, path, row, col);
        dfs(grid, i - 1, j, path, row, col);
        dfs(grid, i, j + 1, path, row, col);
        dfs(grid, i, j - 1, path, row, col);
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    public Point() {}
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) return Integer.compare(this.y, p.y);
        return Integer.compare(this.x, p.x);
    }
}