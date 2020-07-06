package Nuist_OJ.P1126全排列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 全排列
 *
 * @author Zhu
 * @createtime 2020/7/5-19:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            f(n);
        }
    }

    private static void f(int n) {
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        perm(data, 0);
    }

    private static void perm(int[] data, int index) {
        if (index == data.length) {
            String res = "";
            for (int i = 0; i < data.length; i++) {
                res += data[i];
            }
            System.out.println(res);
            return;
        }
        for (int i = index; i < data.length; i++) {
            swap(data, i, index);
            perm(data, index + 1);
            swap(data, i, index);
        }

    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
