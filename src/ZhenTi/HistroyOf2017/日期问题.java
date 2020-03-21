package ZhenTi.HistroyOf2017;

import java.util.Scanner;

/**
 * 标题：日期问题
 * 小明正在整理一批历史文献。这些历史文献中出现了很多日期。
 * 小明知道这些日期都在1960年1月1日至2059年12月31日。
 * 令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。
 * 更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。
 * 比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
 * 给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？
 * <p>
 * 输入
 * ----
 * 一个日期，格式是"AA/BB/CC"。  (0 <= A, B, C <= 9)
 * <p>
 * 输入
 * ----
 * 输出若干个不相同的日期，每个日期一行，格式是"yyyy-MM-dd"。多个日期按从早到晚排列。
 * 样例输入
 * ----
 * 02/03/04
 * 样例输出
 * ----
 * 2002-03-04
 * 2004-02-03
 * 2004-03-02
 *
 * @author Zhu
 * @createtime 2020/3/7-16:14
 */
public class 日期问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] split = data.split("/");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        //年/月/日
        f(a, b, c);
        //月/日/年
        f(c, a, b);
        //日/月/年
        f(c, b, a);

        System.out.println();
    }

    private static void f(int year, int month, int day) {
        if (year >= 0 && year <= 59)
            year += 2000;
        else if (year >= 60 && year <= 99)
            year += 1900;
        else
            return;

        if (month <= 0 || month > 12)
            return;

        if (day <= 0 || day > 31)
            return;

        boolean isRuiYear = isRunYear(year);

        switch (month) {
            case 2:
                if (isRuiYear) {
                    if (month > 29)
                        return;
                } else {
                    if (month > 28)
                        return;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (month > 30) {
                    return;
                }
                break;
            default:
                break;
        }

        ;
        System.out.println(year + "-" +
                (Integer.toString(month).length() == 2 ? "" + month : "0" + month) + "-" +
                (Integer.toString(day).length() == 2 ? "" + day : "0" + day));

    }

    private static boolean isRunYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
