package Nuist_OJ.P1076正整数的商和余数;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 正整数的商和余数
 *
 * @author Zhu
 * @createtime 2020/6/27-20:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.println(f(sc.nextInt(), sc.nextInt()));
            }
        }
    }

    private static String f(int a, int b) {
        return a / b + " " + a % b;
    }
}
