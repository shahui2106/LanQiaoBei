package JiChuTi.FJDeZiFuChuan;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/14-13:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Fj(n));
    }

    /**
     * 每一个字符串等于左右各加一个前面的字符串，
     * 中间在插一个第n位的字母
     * @param n FJ的第几个字符串
     * @return  当前的字符串
     */
    private static String Fj(int n) {
        if (n == 1) return "A";
        return Fj(n-1) + (char)(64+n) + Fj(n-1);
    }
}
