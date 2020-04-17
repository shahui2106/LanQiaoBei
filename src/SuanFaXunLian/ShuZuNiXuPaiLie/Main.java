package SuanFaXunLian.ShuZuNiXuPaiLie;

import java.util.Scanner;

/**
 * 算法训练 -- 数组逆序排列
 *
 * @author Zhu
 * @createtime 2020/4/11-17:11
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[20];
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            int temp = sc.nextInt();
            if (temp != 0) {
                data[i] = temp;
                count++;
            } else
                break;
        }
        //逆序交换数组中的元素
        sort(data, count);
        //打印最后结果
        print(data, count);
    }

    /**
     * 将数组首尾的元素进行交换
     *
     * @param data 需逆序排列的数组
     * @param len  排序的长度
     */
    private static void sort(int[] data, int len) {
        if (len == 0)
            return;
        for (int i = 0; i < (len >> 1); i++) {
            swap(data, i, len - i - 1);
        }
    }

    /**
     * @param data 需排序的数组
     * @param i    位置1
     * @param j    位置2
     */
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //打印数组
    private static void print(int[] data, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
