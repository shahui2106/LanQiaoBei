package SuanFaXunLian.ShiJianZhuanHuan;

import java.util.Scanner;

/**
 * 算法训练 -- 时间转换
 *
 * @author Zhu
 * @createtime 2020/4/26-17:38
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(getFromatTime(t));
    }

    private static String getFromatTime(int t) {
        int sec = t % 60;
        int min = t / 60;
        if (min >= 60) {
            min %= 60;
        }
        int hour = t / 3600;
        return hour + ":" + min + ":" + sec;
    }
}
