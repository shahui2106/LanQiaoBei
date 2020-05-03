package SuanFaXunLian.ChuFaYunSuan;

import java.util.Scanner;

/**
 * 算法训练 -- 除法运算
 *
 * @author Zhu
 * @createtime 2020/5/2-16:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(n % m == 0 ? 1 : 0);
    }
}
