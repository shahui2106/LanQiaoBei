package ZhenTi.FanYingBi;

import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-01-22 16:02
 */
public class Main {
    //翻转次数
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //初始状态
        String start = sc.next();
        //最终状态
        String end = sc.next();

        //对比两种状态是否一致
        compare(start, end);
        System.out.println(count);
    }

    /**
     * 对比两个状态的首字符是否相同
     * 若相同，则比较下一个字符
     * 若不相同，则将相邻的两个字符进行翻转
     *
     * @param start 开始状态的字符串
     * @param end   最终状态的字符串
     */
    private static void compare(String start, String end) {
        if (start.length() <= 1) return;
        if (start.charAt(0) == end.charAt(0))
            compare(start.substring(1), end.substring(1));
        else {
            start = change(start);
            count++;
            compare(start, end);

        }
    }

    /**
     * 将前两个字符进行翻转
     *
     * @param start 开始状态的字符串
     * @return 前两个字符翻转之后的字符串
     */
    private static String change(String start) {
        if (start.length() >= 2)
            return exchanger(start.substring(0, 2)) + start.substring(2);
        else
            return start;
    }

    /**
     * 将相邻的两个字符进行翻转
     *
     * @param s 要翻转的字符
     * @return 翻转之后的字符
     */
    private static String exchanger(String s) {
        String s1 = "";
        if (s.startsWith("*")) {
            s1 += "o";
        } else
            s1 += "*";
        if (s.endsWith("*")) {
            s1 += "o";
        } else
            s1 += "*";
        return s1;
    }
}
