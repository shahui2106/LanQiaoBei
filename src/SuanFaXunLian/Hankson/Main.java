package SuanFaXunLian.Hankson;

import java.util.Scanner;

/**
 * 算法训练 -- Hankson的趣味题
 *
 * @author Zhu
 * @createtime 2020/7/20-9:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i;
        int cnt = 0;
        while (t-- != 0) {
            long a0 = sc.nextLong();
            long a1 = sc.nextLong();
            long b0 = sc.nextLong();
            long b1 = sc.nextLong();
            cnt = 0;
            for (i = 1; i * i < b1; i++) {
                if (b1 % i != 0) continue;
                if (i % a1 == 0 && gcd(i / a1, a0 / a1) == 1 && gcd(b1 / b0, b1 / i) == 1) cnt++;
                if ((b1 / i) % a1 == 0 && gcd(b1 / a1 / i, a0 / a1) == 1 && gcd(b1 / b0, i) == 1) cnt++;
            }
            if (i * i == b1 && gcd(i / a1, a0 / a1) == 1 && gcd(b1 / b0, b1 / i) == 1) cnt++;
            System.out.println(cnt);
        }
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
