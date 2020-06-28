package Nuist_OJ.P1089ACM初学系列6a加b;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]初学系列（6）a+b
 *
 * @author Zhu
 * @createtime 2020/6/28-16:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
