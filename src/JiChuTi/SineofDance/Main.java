package JiChuTi.SineofDance;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/14-14:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Sn(n, n));
    }

    /**
     * n = 1: A1+1
     * n = 2: (A1+2)A2+1
     * n = 3: ((A1+3)A2+2)A1+1
     *
     * @param n 当前Sn中n的值
     * @return 当前Sn的表达式
     */
    private static String Sn(int n, int sum) {
        if (n == 1) return An(1, 1) + "+" + sum;
        return "(" + Sn(n - 1, sum) + ")" + An(n, n) + "+" + (sum - n + 1);
    }

    /**
     * n = 1: sin(1)
     * n = 2: sin(1–sin(2))
     * n = 3: sin(1–sin(2+sin(3))
     * n = 4: sin(1–sin(2+sin(3-sin(4)))
     *
     * @param n 当前An中n的值
     * @return 当前An的表达式
     */
    private static String An(int n, int sum) {
        int tmp = (sum - n + 1);
        String fu = tmp % 2 == 0 ? "+" : "-";
        if (n == 1) return "sin(" + sum + ")";
        return "sin(" + tmp + fu + An(n - 1, sum) + ")";
    }
}
