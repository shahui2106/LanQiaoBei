package SuanFaXunLian.TongJiDanCiGeShu;

import java.util.Scanner;

/**
 * 算法训练 -- 统计单词个数
 *
 * @author Zhu
 * @createtime 2020/3/23-16:02
 */
public class Main {
    static int p;
    static int k;
    static String S;
    static int wordSize;
    static String word[];
    static int num = 0;//所有字符串中含有单词词典中单词的数量
    static int cut;//分割

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();//句子的行数
        k = sc.nextInt();//分为k个部分
        S = sc.nextLine();//每一行的单词
        S = "";//去掉第一行没用的字符串
        for (int i = 0; i < p; i++) {
            S = S + sc.nextLine();
        }
        wordSize = sc.nextInt();//单词词典的大小
        word = new String[wordSize];
        for (int j = 0; j < wordSize; j++) {
            word[j] = sc.next();
        }
        wordCount(S);//统计所有字符串中含有单词词典的个数
        if (cut < k) {
            num = num - (k - 1);
        }
        System.out.println(num);
    }

    /**
     * 统计单词数量
     *
     * @param S 所有的字符串
     */
    public static void wordCount(String S) {
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < wordSize; j++) {
                if (S.substring(i, S.length()).length() < word[j].length()) {
                    continue;
                }
                if (S.substring(i, i + word[j].length()).length() < word[j].length()) {
                    continue;
                }
                if (S.substring(i, i + word[j].length()).equals(word[j])) {
                    num++;
                    if (i != 0) {
                        cut++;
                    }
                    wordCount(S.substring(i + 1, S.length()));
                    return;
                }
            }
        }
    }
}
