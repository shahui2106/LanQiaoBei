package ZhenTi.HostroyOf2013;

import java.util.Calendar;
import java.util.Date;

/**
 * 2013年省赛真题1：
 * 1999年12月31日（星期五）之后最近的哪一个世纪末的12月31日是星期日？
 * 输出四位数，即年份即可。
 *
 * @author zhu
 * @datetime 2020-02-25 15:45
 */
public class Question1 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        Date date = new Date();
        int year = 1999;
        while (true) {
            instance.set(year, 11, 31);
            date = instance.getTime();
            if (date.getDay() == 0) {
                System.out.println(year);
                break;
            }
            year += 100;
        }

    }
}
