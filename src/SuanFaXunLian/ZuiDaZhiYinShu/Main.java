package SuanFaXunLian.ZuiDaZhiYinShu;

import java.util.Scanner;

/**
 * 算法训练 -- 最大质因数
 *
 * @author Zhu
 * @createtime 2020/4/25-14:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxY = 1;
        int ans = 1;
        for (int i = 0; i < N; i++) {
            int A_i = sc.nextInt();
            int temp = getMaxY(A_i);
            if (temp > maxY) {
                maxY = temp;
                ans = A_i;
            }
        }
        System.out.println(ans);
    }

    //获取此数最大的质因数
    private static int getMaxY(int data) {
        int maxvalue = 1;
        for (int i = 2; i <= data; i++) {
            if (data % i == 0) {
                maxvalue = Math.max(maxvalue, i);
                data /= i;
                i = 1;
            }
        }
        return maxvalue;
    }
}
