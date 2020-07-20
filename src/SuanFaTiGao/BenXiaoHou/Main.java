package SuanFaTiGao.BenXiaoHou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法提高 -- 笨小猴
 *
 * @author Zhu
 * @createtime 2020/7/20-9:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dataStr = sc.next();
        int[] table = new int[26];
        for (int i = 0; i < dataStr.length(); i++) {
            table[dataStr.charAt(i) - 97]++;
        }
        Arrays.sort(table);
        for (int i = table.length - 1; i >= 0; i--) {
            if (table[i] == 0) {
                boolean res = isRight(table[table.length - 1] - table[i + 1]);
                System.out.println(res ? "Lucky Word" : "No Answer");
                System.out.println(res ? table[table.length - 1] - table[i + 1] : 0);
                break;
            }
        }
    }

    public static boolean isRight(int res) {
        boolean isRight = true;
        if (res == 0 || res == 1)
            return false;
        for (int i = 2; i * i <= res; i++) {
            if (res % i == 0) {
                isRight = false;
                break;
            }
        }
        return isRight;
    }
}
