package Nuist_OJ.P1132错误序号;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * OJ系统练习题 --  错误序号
 *
 * @author Zhu
 * @createtime 2020/7/6-14:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(f(new BigInteger(String.valueOf(n))));
        }
    }

    private static long f(int n) {
        if (n == 1)
            return 1;
        return (long) (Math.pow(10, n - 1) + 9 * f(n - 1));
    }

    private static BigInteger f(BigInteger n) {
        if (n.intValue() == 1)
            return new BigInteger("1");
        return f(n.subtract(new BigInteger("1"))).multiply(new BigInteger("9")).add(new BigInteger("10").pow(n.intValue() - 1));
    }
}
