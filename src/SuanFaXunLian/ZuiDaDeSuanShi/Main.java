package SuanFaXunLian.ZuiDaDeSuanShi;

import java.util.Scanner;

/**
 * 算法训练 -- 最大的算式
 *
 * @author Zhu
 * @createtime 2020/7/20-10:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        System.out.println(getMaxSum(data, 0, K));
    }

    private static long getMaxSum(int[] data, int start, int multi) {
        if (multi == 0)
            return getSum(data, start, data.length - 1);
        long max = 0;

        for (int i = start; i < data.length - 1; i++) {
            long temp_maxSum = getSum(data, start, i) * getMaxSum(data, i + 1, multi - 1);
            max = Math.max(temp_maxSum, max);
        }
        return max;
    }

    private static long getSum(int[] data, int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += data[i];
        }
        return sum;
    }
}
