package SuanFaTiGao.RiQiJiSuan;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 算法提高 -- 日期计算
 *
 * @author Zhu
 * @createtime 2020/3/21-20:05
 */
public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int date = sc.nextInt();
        sc.close();
        calendar.set(year, month - 1, date);
        int day = calendar.getTime().getDay();
        System.out.println(day == 0 ? 7 : day);
    }
}
