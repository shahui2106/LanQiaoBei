package ZhenTi.DaiFenShu;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/10-14:51
 */
public class Main {
    //所有可能结果
    private static int num = 0;
    //输入的整数值
    private static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //初始化1-9的数组
        int[] data = new int[9];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        //进行全排列，并计算每一个排列满足的结果
        perum(data, 0, data.length - 1);
        System.out.println(num);
    }

    // 交换函数：将数组arr中索引为i和j元素互换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 对数组arr进行全排列
    public static void perum(int[] arr, int p, int q) {
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if (p == q) {
            getResultNum(arr);
        }
        for (int i = p; i <= q; i++) {
            swap(arr, i, p);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr, i, p);
        }
    }

    /**
     * 对每一个全排列数组进行插入符号计算
     * 判断是否有情况满足
     */
    public static void getResultNum(int[] p) {
        int i, j;
        int num1, num2, num3;
        for (i = 1; i <= 7; i++) {
            for (j = 1; j <= 7 - i + 1; j++) {
                if (j < 9 - i - j) {
                    continue;
                } else {
                    num1 = ToNum(p, 0, i);
                    num2 = ToNum(p, i, j);
                    num3 = ToNum(p, i + j, 9 - i - j);
                    if (((num2 % num3) == 0) && (num1 + num2 / num3) == n) {
                        num++;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 抽取数组中的一部分数字
     *
     * @param p 全排列好的数组
     * @param s 开始索引
     * @param n 抽取数字的长度
     * @return 抽取的值
     */
    public static int ToNum(int[] p, int s, int n) {
        int i, temp = 0;
        for (i = 0; i < n; i++) {
            temp = temp * 10 + p[s + i];
        }
        return temp;
    }

}
