package Nuist_OJ.P1158方格上的路径;

import java.util.Scanner;

/**
 * OJ系统练习题 --  方格上的路径
 *
 * @author Zhu
 * @createtime 2020/7/6-15:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.println(dp(sc.nextInt(), sc.nextInt()));
            }
        }
    }

    private static int dp(int n, int m) {
        int[][] table = new int[n + 1][m + 1];
        for (int i = 0; i < table.length; i++) {
            table[i][0] = 1;
        }
        for (int i = 0; i < table[0].length; i++) {
            table[0][i] = 1;
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[1].length; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[n][m];
    }
}
