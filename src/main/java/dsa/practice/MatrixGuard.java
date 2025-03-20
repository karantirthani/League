package dsa.practice;

public class MatrixGuard {
    private void markGuarded(int x, int y, int n, int m, int[][] matrix) {
        for (int j=y; j<n; j++) {
            if (matrix[x][j] == 2) {
                break;
            }
            if (matrix[x][j] == 0) {
                matrix[x][j] = -1;
            }
        }
        for (int j=y; j>=0; j--) {
            if (matrix[x][j] == 2) {
                break;
            }
            if (matrix[x][j] == 0) {
                matrix[x][j] = -1;
            }
        }

        for (int i=x; i<m; i++) {
            if (matrix[i][y] == 2) {
                break;
            }
            if (matrix[i][y] == 0) {
                matrix[i][y] = -1;
            }
        }

        for (int i=x; i>=0; i--) {
            if (matrix[i][y] == 2) {
                break;
            }
            if (matrix[i][y] == 0) {
                matrix[i][y] = -1;
            }
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 1;
        }
        for (int[] wall: walls) {
            matrix[wall[0]][wall[1]] = 2;
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 1) {
                    markGuarded(i, j, n, m , matrix);
                }
            }
        }
        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
