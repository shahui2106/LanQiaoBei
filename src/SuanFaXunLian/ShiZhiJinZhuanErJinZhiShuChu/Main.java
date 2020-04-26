package SuanFaXunLian.ShiZhiJinZhuanErJinZhiShuChu;

import java.util.Scanner;

/**
 * 算法训练 -- 十进制转2进制输出
 *
 * @author Zhu
 * @createtime 2020/4/26-17:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        System.out.println(Integer.toString(data, 2));
    }
}
