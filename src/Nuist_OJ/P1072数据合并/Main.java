package Nuist_OJ.P1072数据合并;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 数据合并
 *
 * @author Zhu
 * @createtime 2020/6/27-17:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] data1 = new int[n];
            int[] data2 = new int[m];
            for (int i = 0; i < data1.length; i++) {
                data1[i] = sc.nextInt();
            }
            for (int i = 0; i < data2.length; i++) {
                data2[i] = sc.nextInt();
            }
            int[] data = merge(data1, data2);
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
        }
    }

    private static int[] merge(int[] data1, int[] data2) {
        int data1_len = data1.length;
        int data2_len = data2.length;
        int[] data = new int[data1_len + data2_len];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int min = Math.min(data1_len, data2_len);
        while (index1 < data1_len && index2 < data2_len) {
            if (data1[index1] <= data2[index2]) {
                data[index] = data1[index1];
                index1++;
                index++;
            } else {
                data[index] = data2[index2];
                index++;
                index2++;
            }
        }
        if (index2 == min) {
            for (int i = min - 1; i < data1_len; i++) {
                data[index] = data1[i];
                index++;
            }
        }
        if (index1 == min) {
            for (int i = min - 1; i < data2_len; i++) {
                data[index] = data2[i];
                index++;
            }
        }
        return data;
    }
}
