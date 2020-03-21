package SuanFaTiGao.ZaiYang;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/3/21-15:06
 */
public class Main {
    public static void main(String[] args) {
        int t, n, m;
        int[] num = new int[100 + 2];
        int[][] dp = new int[100 + 2][100 + 2];
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 1; i <= m; i++) {
                num[i] = sc.nextInt();
            }
            num[0] = 0;
            num[m + 1] = n + 1;
            for (int len = 1; len <= m; len++)
                for (int l = 1; l + len - 1 <= m; l++) {
                    int r = len + l - 1;
                    if (len == 1) {
                        dp[l][r] = num[r + 1] - num[l - 1] - 2;
                    } else {
                        dp[l][r] = 10000000;
                        for (int i = l; i <= r; i++)
                            dp[l][r] = Math.min(dp[l][r], num[r + 1] - num[l - 1] - 2 + dp[l][i - 1] + dp[i + 1][r]);
                    }
                }
            list.add(dp[1][m]);
        }
        sc.close();
        for (int i : list) {
            System.out.println(i);
        }
    }
}
