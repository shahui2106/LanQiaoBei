package ZhenTi.HistroyOf2017;

import java.util.*;

/**
 * 标题： k倍区间
 * <p>
 * 给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，
 * 我们就称这个区间[i, j]是K倍区间。
 * <p>
 * 你能求出数列中总共有多少个K倍区间吗？
 * <p>
 * 输入
 * -----
 * 第一行包含两个整数N和K。(1 <= N, K <= 100000)
 * 以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)
 * <p>
 * 输出
 * -----
 * 输出一个整数，代表K倍区间的数目。
 * <p>
 * 例如，
 * 输入：
 * 5 2
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * @author Zhu
 * @createtime 2020/3/7-20:09
 */
public class K倍区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sum_yu = new int[N + 1];
        long[] sum = new long[N + 1];
        int[] cnt = new int[K];
        cnt[0] = 1;
        for (int i = 1; i <= N; i++) {
            //前缀和
            sum[i] = sum[i - 1] + sc.nextInt();
            sum_yu[i] = (int) ((sum[i]) % K);
            cnt[sum_yu[i]]++;
        }

        long num = 0;
        for (int value : cnt) {
            num += (long) value * ((long) value - 1) / 2;
        }
        System.out.println(num);

    }
}
