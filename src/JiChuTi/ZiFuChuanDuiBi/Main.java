package JiChuTi.ZiFuChuanDuiBi;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/18-14:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //字符串1
        String str1 = sc.next();
        //字符串2
        String str2 = sc.next();

        //第一种情况：两个字符串的长度是不相等
        if (str1.length() != str2.length()) {
            System.out.println("1");
        } else {
            //第二种情况：不仅长度相等，而且每个字符都相同
            if (str1.equals(str2)) {
                System.out.println("2");
                //第三种情况：长度相等，在忽略大小写的情况下是相同的
            } else if (str1.equalsIgnoreCase(str2)) {
                System.out.println("3");
            }
            //第四种情况：在忽略大小写的情况下也只有长度相等
            else {
                System.out.println("4");
            }
        }
    }
}
