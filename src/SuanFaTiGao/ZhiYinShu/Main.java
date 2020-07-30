package SuanFaTiGao.ZhiYinShu;

import java.util.Scanner;

/**
 * 算法提高 -- 质因数
 *
 * @author Zhu
 * @createtime 2020/7/30-13:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + "=" + f(n));
    }

    private static String f(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return i + "*" + f(n / i);
        }
        return String.valueOf(n);
    }
}
