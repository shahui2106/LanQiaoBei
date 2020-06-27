package Nuist_OJ.P1051绝对素数;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 绝对素数
 *
 * @author Zhu
 * @createtime 2020/6/27-17:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int data = sc.nextInt();
                System.out.println(isPrime(data) && isPrime(reserve(data)) ? 1 : 0);
            }
        }
    }

    public static boolean isPrime(int data) {
        boolean isPrime = true;
        if (data == 2)
            return true;
        for (int i = 2; i * i <= data; i++) {
            if (data % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static int reserve(int data) {
        if (data < 10)
            return data;
        StringBuffer res = new StringBuffer(String.valueOf(data)).reverse();
        return Integer.parseInt(String.valueOf(res));
    }
}
