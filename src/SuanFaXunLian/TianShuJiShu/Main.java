package SuanFaXunLian.TianShuJiShu;

import java.util.Scanner;

/**
 * 算法训练 -- 天数计数
 *
 * @author Zhu
 * @createtime 2020/3/21-17:21
 */
public class Main {
    /**
     * 获取当前日期相距一年多少天
     *
     * @param year  年份
     * @param month 月份
     * @param day   日分
     * @return 一年相距此日期的天数
     */
    public static int getDayNum(int year, int month, int day) {
        int dayNum = 0;
        boolean isLeapYear = isLeapYear(year);
        for (int i = 1; i <  month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    dayNum += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dayNum += 30;
                    break;
                case 2:
                    dayNum += isLeapYear ? 29 : 28;
                    break;
            }
        }
        return dayNum + day;
    }

    /**
     * 判断此年份是否闰年
     *
     * @param year 年份
     * @return 闰年返回true，不是返回false
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println(getDayNum(year, month, day));
    }
}
