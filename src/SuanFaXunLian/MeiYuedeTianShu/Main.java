package SuanFaXunLian.MeiYuedeTianShu;

import java.util.Scanner;

/**
 * 算法训练 -- 每月的天数
 *
 * @author Zhu
 * @createtime 2020/5/2-15:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(30);
                break;
            case 2:
                System.out.println(28);
        }
    }
}
