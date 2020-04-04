package SuanFaXunLian.JiOuPanDuan;

import java.util.Scanner;

/**
 * 算法训练 -- 奇偶判断
 *
 * @author Zhu
 * @createtime 2020/4/4-14:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(isEven(n) ? "even" : "odd");
    }

    /**
     * 判断是否是偶数
     *
     * @param n 需要判断的数值
     * @return 是偶数返回true，是奇数返回false
     */
    private static boolean isEven(long n) {
        if ((n & 1) == 0)
            return true;
        else
            return false;
    }
}
