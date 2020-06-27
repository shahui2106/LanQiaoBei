package Nuist_OJ.P1070数据移位;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 数据移位
 *
 * @author Zhu
 * @createtime 2020/6/27-17:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < data.length; i++) {
                data[i] = sc.nextInt();
            }
            k = k % n;
            if (k != 0) {
                for (int i = k; i < data.length; i++) {
                    System.out.println(data[i]);
                }
                for (int i = 0; i < k; i++) {
                    System.out.println(data[i]);
                }
            }
        }
    }
}
