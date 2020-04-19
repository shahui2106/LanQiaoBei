package MoNiSai_2020.XiaoNei.p8;

import java.util.Scanner;

/**
 * 编程题 8：
 * 问题描述
 * 　　小明想知道，满足以下条件的正整数序列的数量：
 * 　　1. 第一项为 n；
 * 　　2. 第二项不超过 n；
 * 　　3. 从第三项开始，每一项小于前两项的差的绝对值。
 * 　　请计算，对于给定的 n，有多少种满足条件的序列。
 * 输入格式
 * 　　输入一行包含一个整数 n。
 * 输出格式
 * 　　输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
 * 样例输入
 * 4
 * 样例输出
 * 7
 * 样例说明
 * 　　以下是满足条件的序列：
 * 　　4 1
 * 　　4 1 1
 * 　　4 1 2
 * 　　4 2
 * 　　4 2 1
 * 　　4 3
 * 　　4 4
 *
 * @author Zhu
 * @createtime 2020/3/22-10:24
 */
public class Main {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] table = new int[n];
        int sum = 1;
        table[0] = 1;
        if (n >= 2) {
            table[1] = 1;
            sum += table[1];
            for (int i = 2; i < n; i++) {
                table[i] = table[i - 2] + table[i - 1];
                sum += table[i];
                sum = sum % 10000;
            }
        }
        System.out.println(sum);
    }
}
