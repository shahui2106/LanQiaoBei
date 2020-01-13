package JiChuTi.JieChengJiSuan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/12-8:42
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    //递归调用BigInteger计算n的阶乘
    public static BigInteger factorial(int n) {
        if (n == 1) return new BigInteger("" + 1);
        return new BigInteger("" + n).multiply(factorial((n - 1)));
    }
}
