package Nuist_OJ.P1091ACM初学系列8a加b;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]初学系列（8）a+b
 *
 * @author Zhu
 * @createtime 2020/6/28-16:42
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int M = sc.nextInt();
                long sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += sc.nextInt();
                }
                System.out.println(sum);
                System.out.println();
            }
        }
    }
}
