package SuanFaXunLian.DanCiFanZhuan;

import java.util.Scanner;

/**
 * 算法训练 -- 单词翻转
 *
 * @author Zhu
 * @createtime 2020/5/2-15:57
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] data = new StringBuilder(str).reverse().toString().split(" ");
        StringBuilder res = new StringBuilder();
        for (String datum : data) {
            res.append(new StringBuilder(datum).reverse() + " ");
        }
        System.out.println(res.toString().trim());
    }
}
