package SuanFaTiGao.ShenFenZhengHaoMaShengJi;

import java.util.Scanner;

/**
 * 算法提高 -- 身份证号码升级
 *
 * @author Zhu
 * @createtime 2020/3/21-19:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String old = sc.next();
        sc.close();
        System.out.println(getNewIdentificationNumber(old));
    }

    /**
     * 将旧的身份证号码升级成新的身份证号码
     *
     * @param oldNumber 旧的身份这个号码
     * @return 返回升级之后的身份证号码
     */
    private static String getNewIdentificationNumber(String oldNumber) {
        String[] table = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] coe = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String newNumber = oldNumber.substring(0, 6) + "19" + oldNumber.substring(6);
        int tmp = 0;
        for (int i = 0; i < newNumber.length(); i++) {
            tmp += coe[i] * Integer.parseInt(newNumber.substring(i, i + 1));
        }
        return newNumber + table[tmp % 11];
    }
}
