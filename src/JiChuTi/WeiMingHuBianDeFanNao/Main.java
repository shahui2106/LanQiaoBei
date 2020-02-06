package JiChuTi.WeiMingHuBianDeFanNao;

import java.util.Scanner;

/**
 * 校内测试 -- 未名湖边的烦恼
 *
 * @author zhu
 * @datetime 2020-02-02 16:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   //还鞋
        int n = sc.nextInt();   //租鞋
        System.out.println(f(m, n));
    }

    /**
     * 利用动态规划求解
     * 状态转移方程：
     * f(m,n) = f(m,n-1) + f(m-1,n)
     *
     * @param m 还鞋的人
     * @param n 租鞋的人
     * @return 排队方式的总数
     */
    private static int f(int m, int n) {
        int[][] tmp = new int[m + 1][n + 1];
        //边界条件
        for (int i = 0; i <= m; i++) {
            tmp[i][0] = 1;
        }

        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j <= n; j++) {
                //n <= m 进行动态规划
                if (j <= i)
                    tmp[i][j] = tmp[i][j - 1] + tmp[i - 1][j];
            }
        }
        return tmp[m][n];
    }
}
