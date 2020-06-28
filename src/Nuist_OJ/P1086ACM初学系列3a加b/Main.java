package Nuist_OJ.P1086ACM初学系列3a加b;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]初学系列（3）a+b
 *
 * @author Zhu
 * @createtime 2020/6/28-16:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long sum = a + b;
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(sum);
        }
    }
}
