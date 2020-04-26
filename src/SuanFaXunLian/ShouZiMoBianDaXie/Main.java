package SuanFaXunLian.ShouZiMoBianDaXie;

import java.util.Scanner;

/**
 * 算法训练 --- 首字母变大写
 *
 * @author Zhu
 * @createtime 2020/4/25-20:38
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder data = new StringBuilder(sc.nextLine().trim());
        char charAt = data.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            data.replace(0, 1, String.valueOf((char) (charAt - 32)));
        }
        for (int i = 1; i < data.length(); i++) {
            char tempChart = data.charAt(i);
            if (tempChart == ' ' || tempChart == '\t' || tempChart == '\r' || tempChart == '\n') {
                data.replace(i + 1, i + 2, String.valueOf((char) (data.charAt(i + 1) - 32)));
            }
        }
        System.out.println(data);
    }
}
