package MoNiSai_2020.ShengNei.P7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 编程题7：
 * 问题描述
 * 　　对于一个 n 行 m 列的表格，我们可以使用螺旋的方式给表格依次填上正整数，我们称填好的表格为一个螺旋矩阵。
 * 　　例如，一个 4 行 5 列的螺旋矩阵如下：
 * 　　1 2 3 4 5
 * 　　14 15 16 17 6
 * 　　13 20 19 18 7
 * 　　12 11 10 9 8
 * 输入格式
 * 　　输入的第一行包含两个整数 n, m，分别表示螺旋矩阵的行数和列数。
 * 　　第二行包含两个整数 r, c，表示要求的行号和列号。
 * 输出格式
 * 　　输出一个整数，表示螺旋矩阵中第 r 行第 c 列的元素的值。
 * 样例输入
 * 4 5
 * 2 2
 * 样例输出
 * 15
 *
 * @author Zhu
 * @createtime 2020/4/18-10:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] data = new int[n][m];
        init(data);
        System.out.println(data[r - 1][c - 1]);
    }

    private static void init(int[][] data) {
        int leftRow = 0, rightCol = data[0].length - 1, rightRow = data.length - 1, leftCol = 0;
        int initValue = 1;
        while (leftCol <= rightCol && leftRow <= rightRow) {//第一行初始化
            for (int i = leftCol; i <= rightCol; i++) {
                data[leftRow][i] = initValue++;
            }
            //最后一列初始化
            for (int i = leftRow + 1; i <= rightRow; i++) {
                data[i][rightCol] = initValue++;
            }
            //最后一行初始化
            for (int i = rightCol - 1; i >= leftCol && rightRow != leftRow; i--) {
                data[rightRow][i] = initValue++;
            }
            //第一列初始化
            for (int i = rightRow - 1; i > leftRow && leftCol != rightCol; i--) {
                data[i][leftCol] = initValue++;
            }
            leftCol++;
            leftRow++;
            rightCol--;
            rightRow--;
        }
    }
}
