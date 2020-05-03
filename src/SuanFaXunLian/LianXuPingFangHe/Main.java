package SuanFaXunLian.LianXuPingFangHe;

import java.util.Scanner;

/**
 * 算法训练 -- 连续平方和
 *
 * @author Zhu
 * @createtime 2020/5/2-15:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println((getSquareSum(m) - getSquareSum(n - 1)));
    }

    //平方和公式
    public static int getSquareSum(int num) {
        return (num * (num + 1) * (num * 2 + 1)) / 6;
    }
}
