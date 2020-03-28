package MoNiSai_2020.p5;

import java.util.Scanner;

/**
 * 编程题 5：
 * 小明对类似于 hello 这种单词非常感兴趣，这种单词可以正好分为四段，第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
 * 　　给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。
 * 　　元音字母包括 a, e, i, o, u，共五个，其他均为辅音字母。
 * 输入格式
 * 　　输入一行，包含一个单词，单词中只包含小写英文字母。
 * 输出格式
 * 　　输出答案，或者为yes，或者为no。
 * 样例输入
 * lanqiao
 * 样例输出
 * yes
 *
 * @author Zhu
 * @createtime 2020/3/22-9:24
 */
public class Main {
    public static void main(String[] args) {
        String table = "aeiou";
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        sc.close();
        int[] tag = new int[data.length()];
        String res = "";
        for (int i = 0; i < data.length(); i++) {
            if (table.contains(data.substring(i, i + 1))) {
                tag[i] = 1;
            } else {
                tag[i] = 0;
            }
            if (i == 0)
                res += tag[i];
            else if (tag[i] != tag[i - 1])
                res += tag[i];
        }
        System.out.println(res.equals("0101") ? "yes" : "no");
    }
}
