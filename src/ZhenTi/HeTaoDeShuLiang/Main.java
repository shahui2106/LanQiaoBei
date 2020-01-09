package ZhenTi.HeTaoDeShuLiang;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/9-12:29
 */
public class Main {
    /**
     * 获取两个数的最大公约数
     *
     * @param a 第一个数
     * @param b 第二数
     * @return 最大公约数的值
     */
    private static int getMaxDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        big = big % small;
        if (big == 0) {
            return small;
        }
        return getMaxDivisor(small, big);
    }

    /**
     * 获取两个数的最小公倍数
     *
     * @param a 第一个数
     * @param b 第二个数
     * @return 最小公倍数的值
     */
    private static int getMaxMultiple(int a, int b) {
        int maxDivisor = getMaxDivisor(a, b);
        return (a / maxDivisor) * (b / maxDivisor) * maxDivisor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if ((a > 0 && a < 30) && (b > 0 && b < 30) && (c > 0 && c < 30)) {
            System.out.println(f(a, b, c));
        }
    }

    //获取三个小组人数的最小公倍数的值
    private static int f(int a, int b, int c) {
        return getMaxMultiple(getMaxMultiple(a, b), c);
    }
}
