package SuanFaXunLian.ZiChuanNiXu;

import java.util.Scanner;

/**
 * 算法训练 -- 字串逆序
 *
 * @author Zhu
 * @createtime 2020/4/4-17:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new StringBuilder(str).reverse());
    }
}
