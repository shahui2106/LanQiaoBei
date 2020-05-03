package SuanFaXunLian.QiuYiJiaDaoxDeHe;

import java.util.Scanner;

/**
 * 算法训练 -- 求1加到x的和
 *
 * @author Zhu
 * @createtime 2020/5/2-15:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        //求和公式
        System.out.println((((1 + x) * x) / 2));
    }
}
