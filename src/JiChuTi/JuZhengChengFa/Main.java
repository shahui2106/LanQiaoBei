package JiChuTi.JuZhengChengFa;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/16-15:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //矩阵的阶数
        int n = sc.nextInt();
        //矩阵的幂数
        int m = sc.nextInt();
        //矩阵
        int[][] data = new int[n][n];
        //计算结果
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        //初始化结果矩阵为单位矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i)
                    result[i][j] = 1;
                else
                    result[i][j] = 0;
            }
        }

        //矩阵进行m次幂运算
        for (int i = 0; i < m; i++) {
            //两个矩阵相乘
            result = matrixMul(result, data);
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 两个矩阵相乘
     *
     * @param result 矩阵1
     * @param data   矩阵2
     * @return 连个矩阵相乘后的结果矩阵
     */
    private static int[][] matrixMul(int[][] result, int[][] data) {
        int[][] res = new int[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            int temp = 0;
            for (int k = 0; k < data.length; k++) {
                for (int j = 0; j < data.length; j++) {
                    temp += result[i][j] * data[j][k];
                }
                res[i][k] = temp;
                temp = 0;
            }
        }
        return res;
    }
}
