package Nuist_OJ.P1134高精度阶乘;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 高精度阶乘
 *
 * @author Zhu
 * @createtime 2020/5/24-20:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()) {
            n = sc.nextInt();
            System.out.println(f2(new BigInteger(String.valueOf(n))));
        }
    }

    private static BigInteger f(BigInteger n) {
        if (n.equals(new BigInteger("1")))
            return new BigInteger("1");
        return f(n.subtract(new BigInteger("1"))).multiply(n);
    }

    private static BigInteger f2(BigInteger n) {
        BigInteger res = new BigInteger("1");
        for (int i = (n).intValue(); i >= 1; i--) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        return res;
    }
}
