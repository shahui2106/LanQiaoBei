package Nuist_OJ.P1085ACM初学系列2a加b;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]初学系列（2）a+b
 *
 * @author Zhu
 * @createtime 2020/6/28-20:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println(sc.nextInt() + sc.nextInt());
            }
        }
    }
}
