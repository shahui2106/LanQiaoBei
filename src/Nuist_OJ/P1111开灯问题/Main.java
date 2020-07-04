package Nuist_OJ.P1111开灯问题;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 开灯问题
 *
 * @author Zhu
 * @createtime 2020/7/4-20:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            f(n, k);
        }
    }

    private static void f(int n, int k) {
        boolean[] data = new boolean[n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = i, l = 1; j <= n; l++, j = l * i) {
                data[j] = !data[j];
            }
        }
        for (int i = 1; i < data.length; i++) {
            if (data[i])
                System.out.println(i);
        }
    }
}
