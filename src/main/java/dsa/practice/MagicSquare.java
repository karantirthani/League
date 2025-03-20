package dsa.practice;

public class MagicSquare {
    private boolean isMagicSquare(int[][] grid, int rs, int cs) {
        int[] distinct = new int[20];
        int targetSum = grid[rs][cs] + grid[rs+1][cs+1] + grid[rs+2][cs+2];
        for (int i=rs; i<=rs+2; i++) {
            int rsum = 0;
            for (int j=cs; j<=cs+2; j++) {
                rsum = rsum + grid[i][j];
                if (distinct[grid[i][j]] == 1) {
                    return false;
                }
                distinct[grid[i][j]]++;
            }

            if (rsum != targetSum) {
                return false;
            }
        }

        for (int i=cs; i<=cs+2; i++) {
            int csum = 0;
            for (int j=rs; j<=rs+2; j++) {
                csum = csum + grid[j][i];
            }
            if (csum != targetSum) {
                return false;
            }
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        if (n<3) {
            return 0;
        }
        int m = grid[0].length;
        if (m<3) {
            return 0;
        }
        int ans = 0;
        for (int i=0; i+2<n; i++) {
            for (int j=0; j+2<m; j++) {
                if (isMagicSquare(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
