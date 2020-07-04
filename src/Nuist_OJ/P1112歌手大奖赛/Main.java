package Nuist_OJ.P1112歌手大奖赛;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 歌手大奖赛
 *
 * @author Zhu
 * @createtime 2020/7/4-21:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                int[] data = new int[n];
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    data[j] = sc.nextInt();
                    sum += data[j];
                    max = Math.max(max, data[j]);
                    min = Math.min(min, data[j]);
                }
                float avg = (float) ((sum - max - min) * 1.0 / (n - 2));
                System.out.println(String.format("%.2f", avg));
            }
        }
    }
}
