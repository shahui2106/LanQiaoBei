package ZhenTi.MaiBuDaoDeShuMu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 历史真题 -- 买不到的数目
 *
 * @author zhu
 * @datetime 2020-02-04 15:57
 */
public class Main {
    //尽量开一个较大的数组，用于标记可以买到的数目
    public static int N = 1000 * 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //糖果个数n1
        int n1 = sc.nextInt();
        //糖果个数n2
        int n2 = sc.nextInt();
        //两者中较小的个数
        int min = Math.min(n1, n2);
        boolean[] points = new boolean[N];
        //标记可以买到的数目
        f(points, n1, n2);
        printMaxValue(points, min);
    }

    /**
     * 打印出最大买不到的数目
     *
     * @param points 标记数据
     * @param min    两包糖果数目中的最小值
     * @return 是否有这个最大买不到的数目
     */
    private static boolean printMaxValue(boolean[] points, int min) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i]) {
                count++;
                if (count == min) {
                    System.out.println(i - count);
                    return true;
                }
            } else
                count = 0;
        }
        return false;
    }

    /**
     * 标记可以买的数目
     *
     * @param points 标记数据
     * @param n1     糖果个数n1
     * @param n2     糖果个数n2
     */
    private static void f(boolean[] points, int n1, int n2) {
        /*
         *  通过公式(n1 * i + n2 * j)，求得：
         *  i 不得超过 N / n1
         *  j 不得超过 (N - n1 * i) / n2
         */
        for (int i = 0; i < N / n1; i++) {
            for (int j = 0; j < (N - n1 * i) / n2; j++) {
                points[n1 * i + n2 * j] = true;
            }
        }
    }
}
