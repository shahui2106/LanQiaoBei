package SuanFaXunLian.DuoJieChengJiSuan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 算法训练 -- 多阶乘计算
 *
 * @author Zhu
 * @createtime 2020/3/21-19:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        BigInteger resBigInt = new BigInteger(String.valueOf(0));
        for (int i = 1; i <= k; i++) {
            BigInteger tmp = getFactorialn_k(n, i);
            resBigInt = resBigInt.add(tmp);
        }
        String res = m == 1 ? resBigInt.toString() : getSum(resBigInt.toString());
        System.out.println(res);
    }

    /**
     * 获取此数各位数之和
     *
     * @param value 此数的值
     * @return 返回各位数之和
     */
    private static String getSum(String value) {
        long res = 0;
        for (int i = 0; i < value.length(); i++) {
            res += Integer.parseInt(value.substring(i, i + 1));
        }
        return "" + res;
    }

    /**
     * 获取一个数的k次方阶乘
     *
     * @param n 要求的阶乘数
     * @param k 阶乘次方
     * @return 返回n的k次阶乘的结果
     */
    private static BigInteger getFactorialn_k(int n, int k) {
        if (n <= 1)
            return new BigInteger(String.valueOf(1));
        BigInteger N = new BigInteger(String.valueOf(n));
        return N.multiply(getFactorialn_k(n - k, k));
    }
}
