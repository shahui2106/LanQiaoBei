package MoNiSai_2020.ShengNei.P8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 编程题8：
 * 问题描述
 * 　　如果一个序列的奇数项都比前一项大，偶数项都比前一项小，则称为一个摆动序列。即 a[2i]<a[2i-1], a[2i+1]>a[2i]。
 * 　　小明想知道，长度为 m，每个数都是 1 到 n 之间的正整数的摆动序列一共有多少个。
 * 输入格式
 * 　　输入一行包含两个整数 m，n。
 * 输出格式
 * 　　输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
 * 样例输入
 * 3 4
 * 样例输出
 * 14
 * 样例说明
 * 　　以下是符合要求的摆动序列：
 * 　　2 1 2
 * 　　2 1 3
 * 　　2 1 4
 * 　　3 1 2
 * 　　3 1 3
 * 　　3 1 4
 * 　　3 2 3
 * 　　3 2 4
 * 　　4 1 2
 * 　　4 1 3
 * 　　4 1 4
 * 　　4 2 3
 * 　　4 2 4
 * 　　4 3 4
 *
 * @author Zhu
 * @createtime 2020/4/18-11:00
 */
public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] data = new int[m + 1];
        Arrays.fill(data, 1);
        p(data, data.length - 1, n);
    }

    public static void p(int[] arr, int endIndex, int n) {
        if (endIndex == 1) {
            arr[endIndex]++;
            if (arr[endIndex] > n)
                return;
        }
        if (endIndex >= arr.length) {
            endIndex--;
        }
        int tem = ++arr[endIndex];
        if (tem > n) {
            arr[endIndex] = 1;
            p(arr, endIndex - 1, n);
        } else {
            System.out.println(Arrays.toString(arr));
            p(arr, endIndex + 1, n);
        }
    }
}
