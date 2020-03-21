package SuanFaTiGao.JuZhenDaoZhi;

import java.util.Scanner;

/**
 * 算法提高 -- 矩阵倒置
 *
 * @author Zhu
 * @createtime 2020/3/21-22:28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] data = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                data[j][i] = sc.nextInt();
            }
        }
        sc.close();
        //遍历数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
