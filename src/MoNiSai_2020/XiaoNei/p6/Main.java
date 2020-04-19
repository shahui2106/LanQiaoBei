package MoNiSai_2020.XiaoNei.p6;

import java.util.Scanner;

/**
 * 编程题6：
 * 问题描述
 * 　　一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，例如1135是一个数位递增的数，而1024不是一个数位递增的数。
 * 　　给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
 * 输入格式
 * 　　输入的第一行包含一个整数 n。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 30
 * 样例输出
 * 26
 *
 * @author Zhu
 * @createtime 2020/3/22-9:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isIncresing(i)) {
                res++;
            }
        }
        System.out.println("\n" + res);
    }

    private static boolean isIncresing(int num) {
        if (num < 10)
            return true;
        String tmp = String.valueOf(num);
        return compare(tmp.substring(0, 1), tmp.substring(1));
    }

    private static boolean compare(String s1, String s2) {
        if (s1.compareTo(s2.substring(0, 1)) <= 0) {
            if (s2.length() != 1)
                return compare(s2.substring(0, 1), s2.substring(1));
            else return true;
        } else return false;
    }
}
