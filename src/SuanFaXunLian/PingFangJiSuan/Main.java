package SuanFaXunLian.PingFangJiSuan;

import java.util.Scanner;

/**
 * 算法训练 -- 平方计算
 *
 * @author Zhu
 * @createtime 2020/4/5-20:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        int res = 0;
        for (int i = 0; i < a; i++) {
            res += a;
            while (res >= m)
                res -= m;
        }
        System.out.println(res);
    }
}
