package MoNiSai_2020.p7;

import java.util.Scanner;

/**
 * 编程题7：
 * 问题描述
 * 　　在数列 a[1], a[2], ..., a[n] 中，如果对于下标 i, j, k 满足 0<i<j<k<n+1 且 a[i]<a[j]<a[k]，则称 a[i], a[j], a[k] 为一组递增三元组，a[j]为递增三元组的中心。
 * 　　给定一个数列，请问数列中有多少个元素可能是递增三元组的中心。
 * 输入格式
 * 　　输入的第一行包含一个整数 n。
 * 　　第二行包含 n 个整数 a[1], a[2], ..., a[n]，相邻的整数间用空格分隔，表示给定的数列。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 5
 * 1 2 5 3 5
 * 样例输出
 * 2
 *
 * @author Zhu
 * @createtime 2020/3/22-10:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        sc.close();
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = i; j >= 0; j--) {
                if (data[j] < data[i]) {
                    tmp++;
                    break;
                }

            }
            for (int j = i; j < n; j++) {
                if (data[i] < data[j]) {
                    tmp++;
                    break;
                }
            }
            if (tmp == 2) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
