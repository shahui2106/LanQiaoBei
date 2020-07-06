package Nuist_OJ.P1142Encoding;

import java.util.Scanner;

/**
 * OJ系统练习题 -- Encoding
 *
 * @author Zhu
 * @createtime 2020/7/6-15:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] res = new String[n];
            for (int i = 0; i < n; i++) {
                res[i] = f(sc.next());
            }
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static String f(String data) {
        char curChar = data.charAt(0);
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < data.length(); i++) {
            char tmp = data.charAt(i);
            if (tmp == curChar)
                count++;
            else {
                res.append((count == 1 ? "" : count) + "" + curChar);
                curChar = tmp;
                count = 1;
            }
        }
        res.append((count == 1 ? "" : count) + "" + curChar);
        return res.toString();
    }
}
