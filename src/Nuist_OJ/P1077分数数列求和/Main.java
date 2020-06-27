package Nuist_OJ.P1077分数数列求和;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 分数数列求和
 *
 * @author Zhu
 * @createtime 2020/6/27-20:08
 */
public class Main {
    public static long[] table = new long[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        table[0] = 1;
        table[1] = 1;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(f2(n));
        }
    }

    private static String getSum(int n) {
        FenShu res = new FenShu(getNum(2), getNum(1));
        for (int i = 2; i <= n; i++) {
            FenShu fenShu2 = new FenShu((long) (Math.pow(-1, i + 1) * getNum(i + 1)), getNum(i));
            res = add(res, fenShu2);
        }
        if (n == 0)
            return "0.0000";
        return String.format("%.4f", res.fenzi / (res.fenmu * 1.0));
    }

    public static long getNum(int index) {
        if (index == 1 || index == 0)
            return 1;
        if (table[index] != 0)
            return table[index];
        else {
            table[index] = getNum(index - 1) + getNum(index - 2);
            return table[index];
        }
    }

    public static FenShu add(FenShu fenShu1, FenShu fenShu2) {
        long a = fenShu1.fenzi * fenShu2.fenmu + fenShu2.fenzi * fenShu1.fenmu;
        long b = fenShu1.fenmu * fenShu2.fenmu;
        return new FenShu(a, b);
    }

    static class FenShu {
        long fenzi;
        long fenmu;

        public static long gcd(long n, long m) {
            if (m == 0) return n;
            return gcd(m, n % m);
        }

        FenShu(long fenzi, long fenmu) {
            long gcd = gcd(fenzi, fenmu);
            this.fenzi = fenzi / gcd;
            this.fenmu = fenmu / gcd;
        }
    }

    public static String f2(int n) {
        int i = 1, b = 1, c = 2, t;
        double a, s = 0;
        while (i <= n) {
            if ((i & 1) == 1)
                a = c * 1.0 / b;
            else
                a = -1 * c * 1.0 / b;
            s += a;
            i++;
            t = c;
            c = b + c;
            b = t;
        }
        return String.format("%.4f", s);
    }

}
