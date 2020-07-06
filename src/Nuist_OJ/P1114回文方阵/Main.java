package Nuist_OJ.P1114回文方阵;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 回文方阵
 *
 * @author Zhu
 * @createtime 2020/7/5-18:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            f(n);
        }
    }

    private static void f(int n) {
        int[][] data = new int[n][n];
        int top = 0, left = 0, right = n - 1, down = n - 1;

        int num = 1;
        while (top <= down && left <= right) {

            int curRow = top, curCol = right;

            for (int i = curRow; i <= down; i++) {
                data[i][curCol] = num;
                num++;
            }

            curRow = down;
            for (int i = curCol - 1; i >= left; i--) {
                data[curRow][i] = num;
                num++;
            }

            curCol = left;
            if (curCol != right)
                for (int i = curRow - 1; i >= top; i--) {
                    data[i][curCol] = num;
                    num++;
                }

            curRow = top;
            if (curRow != down)
                for (int i = curCol + 1; i <= right - 1; i++) {
                    data[curRow][i] = num;
                    num++;
                }

            top++;
            left++;
            right--;
            down--;

        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

    }
}
