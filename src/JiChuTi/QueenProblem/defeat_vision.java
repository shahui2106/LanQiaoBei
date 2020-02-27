package JiChuTi.QueenProblem;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/13-10:34
 */
public class defeat_vision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n][n];
        //初始化棋盘数据
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data.length; i1++) {
                data[i][i1] = sc.nextInt();
            }
        }

        //获取一种皇后摆放的个数
        int num = getQueenStyleNum(data);
        System.out.println(num);

    }

    private static int getQueenStyleNum(int[][] data) {
        //数组的序列号代表行，值代表列
        int[] style = new int[data.length];
        int num = 0;
        boolean isrow = false;
        for (int i = 0; i < style.length; i++) {
            style[i] = -1;
        }

        int row = 0;
        while (row < style.length) {
            if (row == -1 || style[0] >= style.length)
                break;
            for (int col = 0; col < style.length; col++) {
                if (isHasCow(style, row, col) || isHasRowAndCow(style, row, col) || data[row][col] == 0) {
                    isrow = true;
                    continue;
                } else {
                    style[row] = col;
                    row++;
                    isrow = false;
                    break;
                }
            }
            if (row == style.length) {
                num++;
                style[0]++;
                row = 1;
                for (int i = 1; i < style.length; i++) {
                    style[i] = -1;
                }
            }
            if (isrow && style[row] == -1)       //回退
            {
                style[row - 1]++;
                while (isHasCow(style, row - 1, style[row - 1]) || isHasRowAndCow(style, row - 1, style[row - 1])) {
                    style[row - 1]++;
                }
                while (style[row - 1] < style.length) {
                    if (data[row - 1][style[row - 1]] == 0) {
                        while (isHasCow(style, row - 1, style[row - 1]) || isHasRowAndCow(style, row - 1, style[row - 1])) {
                            style[row - 1]++;
                        }
                    } else
                        break;
                }
                while (style[row - 1] >= style.length) {  //超出列的范围后，再次回退
                    if (row - 1 == 0 && style[row - 1] == style.length)
                        break;
                    style[row - 1] = -1;
                    row--;
                    if (row >= 0)
                        style[row - 1]++;
                    else
                        break;
                }
            }
        }
        return num;
    }

    //判断斜对角是否有皇后
    private static boolean isHasRowAndCow(int[] style, int row, int col) {
        if (row == 0)
            return false;
        if (col == 0) {
            if (style[row - 1] == col + 1)
                return true;
        }
        if (style[row - 1] == col - 1 || style[row - 1] == col + 1)
            return true;
        return false;
    }

    //判断此列有没有皇后
    private static boolean isHasCow(int[] style, int row, int col) {
        for (int i1 = 0; i1 < row; i1++) {
            if (style[i1] == col)
                return true;
        }
        return false;
    }


}
