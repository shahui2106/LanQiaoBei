package Nuist_OJ.P1130AllinAll;

import java.util.Scanner;

/**
 * OJ系统练习题 -- All in All
 *
 * @author Zhu
 * @createtime 2020/7/6-13:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] data = sc.nextLine().split(" ");
            int subLen = LCS(data[0], data[1]);
            System.out.println((subLen >= data[0].length() ? "Yes" : "No"));
        }
    }

    private static int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] table = new int[len2][len1];

        //初始化第一行
        for (int i = 0; i < len1; i++) {
            if (str2.charAt(0) == str1.charAt(i))
                table[0][i] = 1;
            else {
                if (i - 1 > 0)
                    table[0][i] = table[0][i - 1];
                else
                    table[0][i] = 0;
            }
        }

        //初始第一列
        for (int i = 0; i < len2; i++) {
            if (str1.charAt(0) == str2.charAt(i))
                table[i][0] = 1;
            else {
                if (i - 1 > 0)
                    table[i][0] = table[i - 1][0];
                else
                    table[i][0] = 0;
            }
        }

        for (int i = 1; i < len2; i++) {
            for (int j = 1; j < len1; j++) {
                if (str1.charAt(j) == str2.charAt(i))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[len2 - 1][len1 - 1];
    }
}
