package SuanFaXunLian.KaiXinDeJinMing;

import java.util.Scanner;

/**
 * 算法训练 -- 开心的金明
 *
 * @author Zhu
 * @createtime 2020/8/10-9:57
 */
public class Main {
    //价格
    public static int[] v;
    //重要度
    public static int[] w;
    //总价格
    public static int sumValue;
    //物品个数
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sumValue = sc.nextInt();
        n = sc.nextInt();
        v = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        System.out.println(dp());
    }

    public static int dp() {
        int[][] table = new int[n][sumValue + 1];
        for (int i = 0; i < table[0].length; i++) {
            if (i >= v[0])
                table[0][i] = w[0] * v[0];
            else
                table[0][i] = 0;
        }


        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (j >= v[i]) {
                    int tmp1 = v[i] * w[i] + table[i - 1][j - v[i]];
                    int tmp2 = table[i - 1][j];
                    table[i][j] = Math.max(tmp1, tmp2);
                } else
                    table[i][j] = table[i - 1][j];
            }
        }
        return table[n - 1][sumValue];
    }
}
