package SuanFaXunLian.ZiFuChuanBiJiao;

import java.util.Scanner;

/**
 * 算法训练 -- 字符串比较
 *
 * @author Zhu
 * @createtime 2020/4/11-17:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = sc.nextInt();
        System.out.println(strncmp(s, t, n));
    }

    private static int strncmp(String s, String t, int n) {
        String S = s.substring(0, n);
        String T = t.substring(0, n);
        int value = S.compareTo(T);
        if (value != 0) {
            value /= Math.abs(value);
        }
        return value;
    }
}
