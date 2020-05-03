package SuanFaXunLian.FuErJinZhi;

import java.util.Scanner;

/**
 * 算法训练 -- -2进制
 *
 * @author Zhu
 * @createtime 2020/5/2-17:26
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            res.append("0");
        }
        while (n != 0) {
            if (n % -2 != 0) {
                if (n > 0)
                    n = n / -2;
                else
                    n = n / -2 + 1;
                res.append("1");
            } else {
                n /= -2;
                res.append("0");
            }
        }
        System.out.println(res.reverse());
    }
}
