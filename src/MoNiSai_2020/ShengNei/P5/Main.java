package MoNiSai_2020.ShengNei.P5;

import java.util.Scanner;

/**
 * 编程题5：
 * 问题描述
 * 　　给定一个单词，请使用凯撒密码将这个单词加密。
 * 　　凯撒密码是一种替换加密的技术，单词中的所有字母都在字母表上向后偏移3位后被替换成密文。即a变为d，b变为e，...，w变为z，x变为a，y变为b，z变为c。
 * 　　例如，lanqiao会变成odqtldr。
 * 输入格式
 * 　　输入一行，包含一个单词，单词中只包含小写英文字母。
 * 输出格式
 * 　　输出一行，表示加密后的密文。
 * 样例输入
 * lanqiao
 * 样例输出
 * odqtldr
 *
 * @author Zhu
 * @createtime 2020/4/18-9:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        System.out.println(jiaMi(data));
    }

    private static String jiaMi(String data) {
        StringBuilder res = new StringBuilder();
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int temp = chars[i] + 3;
            if (temp > 122)
                temp -= 26;
            res.append((char) temp);
        }
        return res.toString();
    }
}
