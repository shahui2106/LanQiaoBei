package JiChuTi.XinPianCeShi;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/16-9:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //芯片的个数
        int n = sc.nextInt();
        int[][] data = new int[n][n];
        //初始化测试结果
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        //判断当前列（即当前芯片是否是好的）
        for (int i = 0; i < n; i++) {
            if (getCurrentColIsGood(data, i)) {
                System.out.print((i+1) + " ");
            }
        }
    }

    /**
     * 判断当前芯片是否是好的
     * 由于好的芯片比坏的芯片多，所以拿其他芯片测试此芯片，1多表示此芯片是好的，0多表示此芯片是坏的
     * @param data
     * @param i
     * @return
     */
    private static boolean getCurrentColIsGood(int[][] data, int i) {
        //记录当前列0的个数
        int sum_0 = 0;
        //记录当前列1的个数
        int sum_1 = 0;
        for (int i1 = 0; i1 < data.length; i1++) {
            if (data[i1][i] == 0)
                sum_0++;
            else sum_1++;
        }
        if (sum_1 >= sum_0)
            return true;
        else
            return false;

    }
}
