package Nuist_OJ.P1531字符串排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 字符串排序
 *
 * @author Zhu
 * @createtime 2020/5/24-20:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] data = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            data[i] = sc.nextLine();
        }
        Arrays.sort(data);
        for (int i = 1; i <= n; i++) {
            System.out.println(data[i]);
        }
    }
}
