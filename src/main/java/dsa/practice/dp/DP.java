package dsa.practice.dp;

public class DP {
    public int mincostTickets(int[] days, int[] costs) {
        int m = days.length;
        int n = costs.length;
        int amount = days[m - 1];
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        int x = 0;
        for (int j = 1; j <= amount; j++) {
            if (j == days[x]) {
                dp[0][j] = dp[0][j - 1] + costs[0];
                x++;
            } else {
                dp[0][j] = dp[0][j - 1];
            }

        }
        for (int i = 1; i < n; i++) {
            x=0;
            for (int j = 1; j <= amount; j++) {
                if (days[x] != j) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                x++;
                if (i == 1 && j >= 7) {
                    if (dp[i - 1][j - 7] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1] + costs[0], Math.min(dp[i - 1][j], dp[i - 1][j - 7] + costs[1]));
                    }
                } else if (i == 2 && j >= 30) {
                    if (dp[i - 1][j - 30] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1] + costs[0], Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 30] + costs[2]), dp[i-1][j-7] + costs[1]));
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][amount];
    }
}
