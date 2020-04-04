package SuanFaXunLian.DaXiaoXiePanDuan;

import java.util.Scanner;

/**
 * 算法训练 -- 大小写判断
 *
 * @author Zhu
 * @createtime 2020/4/4-17:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = s.charAt(0);
        if (c >= 65 && c <= 90)
            System.out.println("upper");
        else
            System.out.println("lower");
    }
}
