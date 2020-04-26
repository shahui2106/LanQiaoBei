package MoNiSai_2020.ShengNei.P6;

import java.util.Scanner;

/**
 * 编程题6：
 * 问题描述
 * 　　给定三个整数 a, b, c，如果一个整数既不是 a 的整数倍也不是 b 的整数倍还不是 c 的整数倍，则这个数称为反倍数。
 * 　　请问在 1 至 n 中有多少个反倍数。
 * 输入格式
 * 　　输入的第一行包含一个整数 n。
 * 　　第二行包含三个整数 a, b, c，相邻两个数之间用一个空格分隔。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 30
 * 2 3 6
 * 样例输出
 * 10
 *
 * @author Zhu
 * @createtime 2020/4/18-9:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] path = new int[n + 1];
        int min = Math.min(a, b);
        min = Math.min(min, c);
        for (int i = 1; i <= path.length / min; i++) {
            if (a * i <= n)
                path[a * i] = 1;
            if (b * i <= n)
                path[b * i] = 1;
            if (c * i <= n)
                path[c * i] = 1;
        }
        int ans = 0;
        for (int i = 1; i <= path.length - 1; i++) {
            if (path[i] == 0)
                ans++;
        }
        System.out.println(ans);
    }
}
