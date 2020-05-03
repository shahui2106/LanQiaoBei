package SuanFaXunLian.BuYuXue;

import java.util.Scanner;

/**
 * 算法训练 -- 步与血
 *
 * @author Zhu
 * @createtime 2020/5/2-16:17
 */
public class Main {
    static int[][] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        data = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            data[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        System.out.println(dp(c) >= 0 ? 2 * (n - 1) : "No");
    }

    private static int dp(int c) {
        int[][] tmp = new int[data.length][data.length];
        tmp[0][1] = c;
        tmp[1][0] = c;
        for (int x = 1; x < tmp.length; x++) {
            for (int y = 1; y < tmp[0].length; y++) {
                tmp[x][y] = Math.max(tmp[x - 1][y] - data[x][y], tmp[x][y - 1] - data[x][y]);
            }
        }
        return tmp[data.length - 1][data.length - 1];
    }
}
