package Nuist_OJ.P1084ACM初学系列1a加b;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]初学系列（1）a+b
 *
 * @author Zhu
 * @createtime 2020/6/28-16:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long sum = a + b;
            System.out.println(sum);
        }
    }
}
