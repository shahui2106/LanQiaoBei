package Nuist_OJ.P1049求表达式值;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 求表达式值
 *
 * @author Zhu
 * @createtime 2020/6/27-17:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            float x = sc.nextFloat();
            float y = sc.nextFloat();
            System.out.println(String.format("%.6f", (x + a % 3 * (int) (x + y) % 2 / 4)));
        }
    }
}
