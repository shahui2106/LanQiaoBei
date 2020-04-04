package SuanFaXunLian.YiDeGeShu;

import java.util.Scanner;

/**
 * 算法训练 -- 1的个数
 *
 * @author Zhu
 * @createtime 2020/4/4-14:40
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getYiSum(n));
    }

    /**
     * 判断从 1 到 n 一共有多少个 1
     *
     * @param n 判断的那个数
     * @return 返回 1 的个数
     */
    private static int getYiSum(int n) {
        int[] table = new int[n + 1];
        for (int i = 1; i < table.length; i++) {
            //判断i中 1 的个数
            int sum = 0;
            char[] chars = ("" + i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1')
                    sum++;
            }
            table[i] = table[i - 1] + sum;
        }
        return table[n];
    }
}
