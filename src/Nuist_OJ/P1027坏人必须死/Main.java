package Nuist_OJ.P1027坏人必须死;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 坏人必须死
 *
 * @author Zhu
 * @createtime 2020/6/6-16:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(f2(sc.nextInt()));
        }
    }

    static int ysf(int sum, int k, int n) {
        if (n == 1) {
            return (sum + k - 1) % sum + 1;
        }
        return (ysf(sum - 1, k, n - 1) + k - 1) % sum + 1;
    }


    public static int f2(int m) {
        int sum = 2 * m, n = 0;
        int k = m + 1;
        while (++n <= m) {
            int t = ysf(sum, k, n);
            if (t <= m) {
                n = 0;
                k++;
            }
        }
        return k;
    }
}
