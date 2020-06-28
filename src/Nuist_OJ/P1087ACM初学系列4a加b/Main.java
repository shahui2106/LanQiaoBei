package Nuist_OJ.P1087ACM初学系列4a加b;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]初学系列（4）a+b
 *
 * @author Zhu
 * @createtime 2020/6/28-16:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n != 0) {
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += sc.nextInt();
                }
                System.out.println(sum);
            } else
                break;
        }
    }
}
