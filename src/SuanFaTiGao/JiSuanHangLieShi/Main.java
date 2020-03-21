package SuanFaTiGao.JiSuanHangLieShi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 算法提高 -- 计算行列式
 *
 * @author Zhu
 * @createtime 2020/3/21-20:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        System.out.println(getDeterminantValue(data, 0, new ArrayList<Integer>()));
    }

    /**
     * 计算此行列式的值
     *
     * @param data 行列式
     * @param r    行
     * @param cols 去掉的列集合
     * @return 返回此行列式的值
     */
    private static int getDeterminantValue(int[][] data, int r, ArrayList<Integer> cols) {
        int res = 0;
        int col = 0;
        if (r == data.length - 1) {
            return data[r][remain(cols, data.length)];
        }
        for (int i = 0; i < data.length; i++) {
            if (!cols.contains(i)) {
                cols.add(i);
                col++;
                res += (int) (Math.pow(-1, col + 1) * data[r][i] * getDeterminantValue(data, r + 1, cols));
                cols.remove(new Integer(i));//回溯
            }

        }
        return res;
    }

    /**
     * 剩下的最后一列
     *
     * @param cols   去掉的列集合
     * @param length 行列式的长度
     * @return 返回剩下的最后一列，没有则返回-1
     */
    private static int remain(ArrayList<Integer> cols, int length) {
        for (int i = 0; i < length; i++) {
            if (cols.contains(i))
                continue;
            else
                return i;
        }
        return -1;
    }
}
