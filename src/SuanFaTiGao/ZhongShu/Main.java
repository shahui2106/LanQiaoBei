package SuanFaTiGao.ZhongShu;

import java.util.Scanner;

/**
 * 算法提高 -- 种树
 *
 * @author Zhu
 * @createtime 2020/7/30-13:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        //如果m大于n的一半，那么将无法成功种植
        if (n / 2 < m) {
            System.out.println("Error!");
        } else {
            int i;
            int j;
            int[][][][] dp;
            int num;
            num = m + 1;
            dp = new int[n][2][2][num];
            dp[0][1][0][1] = A[0];
            dp[0][0][1][1] = A[0];
            for (i = 1; i < n; i++) {
                for (j = 1; j < num; j++) {
                    dp[i][0][0][j] = Integer.MIN_VALUE / 2;
                    dp[i][1][0][j] = Integer.MIN_VALUE / 2;
                    dp[i][0][1][j] = Integer.MIN_VALUE / 2;
                    dp[i][1][1][j] = Integer.MIN_VALUE / 2;
                }
            }
            if (n > 1) {
                dp[1][0][1][1] = A[1];
                dp[1][1][0][1] = A[0];
            }
            if (n > 2) {
                dp[2][1][0][1] = A[0];
                dp[2][0][1][1] = A[2];
                if (m > 2) dp[2][1][1][2] = A[0] + A[2];
                dp[2][0][0][1] = A[1];
            }
            for (i = 3; i < n; i++) {
                for (j = 0; j < num; j++) {
                    dp[i][0][0][j] = Math.max(dp[i - 1][0][0][j], dp[i - 1][0][1][j]);
                    dp[i][1][0][j] = Math.max(dp[i - 1][1][0][j], dp[i - 1][1][1][j]);
                    if (j > 1 && j * 2 <= i + 1) dp[i][0][1][j] = dp[i - 1][0][0][j - 1] + A[i];
                    else if (j == 1) dp[i][0][1][j] = A[i];
                    if (j > 1) dp[i][1][1][j] = dp[i - 1][1][0][j - 1] + A[i];
                }
            }
            System.out.println(Math.max(dp[n - 1][0][0][m], Math.max(dp[n - 1][0][1][m], dp[n - 1][1][0][m])));
        }
    }
}
