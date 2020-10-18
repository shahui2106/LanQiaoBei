package Nuist_OJ.P1029滑雪;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 滑雪
 *
 * @author Zhu
 * @createtime 2020/6/6-19:23
 */
public class Main {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int max = 0;
            int[][] data = new int[n][m];
            dp = new int[n][m];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    f(data, i, j, n, m);
                }
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println(max);
        }
    }

    private static int f(int[][] data, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];

        if (j - 1 > 0) {
            if (data[i][j] > data[i][j - 1])
                dp[i][j] = Math.max(f(data, i, j - 1, n, m) + 1, dp[i][j]);
        } else
            dp[i][j] = Math.max(f(data, i, j - 1, n, m) + 1, dp[i][j]);
        if (j + 1 < m) {
            if (data[i][j] > data[i][j + 1])
                dp[i][j] = Math.max(f(data, i, j + 1, n, m) + 1, dp[i][j]);
        } else
            dp[i][j] = Math.max(f(data, i, j + 1, n, m) + 1, dp[i][j]);
        if (i - 1 >= 0) {
            if (data[i][j] > data[i - 1][j])
                dp[i][j] = Math.max(f(data, i - 1, j, n, m) + 1, dp[i][j]);
        } else
            dp[i][j] = Math.max(f(data, i - 1, j, n, m) + 1, dp[i][j]);
        if (i + 1 < n) {
            if (data[i][j] > data[i + 1][j])
                dp[i][j] = Math.max(f(data, i + 1, j, n, m) + 1, dp[i][j]);
        } else
            dp[i][j] = Math.max(f(data, i + 1, j, n, m) + 1, dp[i][j]);
        return dp[i][j];
    }
}
