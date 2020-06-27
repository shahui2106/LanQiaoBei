package Nuist_OJ.P1120大整数加法;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 大整数加法
 *
 * @author Zhu
 * @createtime 2020/5/24-21:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1, num2;
        while (sc.hasNext()) {
            num1 = sc.next();
            num2 = sc.next();
            System.out.println(new BigInteger(num1).add(new BigInteger(num2)));
        }
    }
}
