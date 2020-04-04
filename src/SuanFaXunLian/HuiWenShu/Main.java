package SuanFaXunLian.HuiWenShu;

import java.util.Scanner;

/**
 * 算法训练 -- 回文数
 *
 * @author Zhu
 * @createtime 2020/4/4-15:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String M = sc.next();
        int step = 0;
        while (step <= 30 && !isPalindrome(M)) {
            M = add(M, N);
            step++;
        }
        if (step > 30)
            System.out.println("Impossible!");
        else
            System.out.println("STEP=" + step);
    }

    //判断 m 是否为回文数
    private static boolean isPalindrome(String m) {
        StringBuilder builder = new StringBuilder(m);
        return builder.reverse().toString().equals(m);
    }

    /**
     * 将n进制数M 和 它自己反转之后相加的和
     *
     * @param m 数值
     * @param n 进制
     * @return 返回与自己反转之后的和
     */
    public static String add(String m, int n) {
        if (n != 10) {
            long t1 = Long.parseLong(m, n);
            long t2 = Long.parseLong(new StringBuilder(m).reverse().toString(), n);
            return Long.toString(t1 + t2, n);
        } else {
            return String.valueOf(Long.parseLong(m) + Long.parseLong(new StringBuilder(m).reverse().toString()));
        }
    }
}
