package SuanFaTiGao.ZuiChangGongGongZiXuLie;

import java.util.Scanner;

/**
 * 算法提高 -- 最长公共子序列
 *
 * @author zhu
 * @datetime 2020-02-14 10:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int res = dp(str1, str2);
        System.out.println(res);
    }

    /**
     * f(str1,str2)的最大公共子序列长度为：
     * ① 若最后一个字符相等，则等于f(str1.substring(0,length-1),str2.substring(0,length-1)) + 1;
     * ② 若最后一个字符不相等，则等于max{f(str1,str2.substring(0,length-1)),f(str1.substring(0,length-1),str2)}
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最大公共子序列长度
     */
    private static int dp(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] table = new int[length1 + 1][length2 + 1];
        //边界条件
        for (int i = 0; i < table.length; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i < table[0].length; i++) {
            table[0][i] = 0;
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[length1][length2];
    }
}
