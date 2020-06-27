package Nuist_OJ.P1043直角三角形;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 直角三角形
 *
 * @author Zhu
 * @createtime 2020/6/27-16:41
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(f(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }

    private static String f(int a, int b, int c) {
        int[] data = new int[3];
        data[0] = a;
        data[1] = b;
        data[2] = c;
        Arrays.sort(data);
        if (Math.pow(data[0], 2) + Math.pow(data[1], 2) == Math.pow(data[2], 2))
            return "yes";
        else
            return "no";
    }
}
