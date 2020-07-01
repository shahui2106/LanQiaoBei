package SuanFaXunLian.ShiZiYouXi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法训练 -- 石子游戏
 *
 * @author Zhu
 * @createtime 2020/4/11-17:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        long sum = 0;
        for (int i = data.length - 1; i > 0; i--) {
            sum += (data[i] + 1) * (data[i - 1] + 1);
            data[i - 1] = data[i] + data[i - 1];
        }
        System.out.println(sum);
    }
}
