package SuanFaXunLian.JuZhenYuanSuDuiJiaoXianZhiHe;

import java.util.Scanner;

/**
 * 算法训练 -- 矩阵对角线元素之和
 *
 * @author Zhu
 * @createtime 2020/5/2-15:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = sc.nextInt();
                if (i == j || i + j == 3) {
                    sum += temp;
                }
            }
        }
        System.out.println(sum);
    }
}
