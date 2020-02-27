package JiChuTi.QuHuiWenShu;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/13-16:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数组的行数
        int m = sc.nextInt();
        //数组的列数
        int n = sc.nextInt();
        int[][] data = new int[m][n];
        //回文遍历结果
        StringBuffer result = new StringBuffer();
        //初始化数据
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data[i].length; i1++) {
                data[i][i1] = sc.nextInt();
            }
        }
        //数组行和列的最小值
        int minLength = Math.min(m, n);
        //依次取出数组最外面的元素
        for (int i = 0; minLength >= 1; i++) {
            minLength -= 2;
            result.append(getOutElement(data, i));
        }
        System.out.println(result);

    }

    /**
     * 取出数组最外面一层的元素
     * @param data 操作的数组数据
     * @param start 从那一层取
     * @return 此层数组的元素
     */
    public static StringBuffer getOutElement(int[][] data, int start) {
        StringBuffer result = new StringBuffer();
        int row = data.length - 2 * start;
        int col = data[0].length - 2 * start;
        if (row == 1) {
            for (int i = start; i < start + col; i++) {
                result.append( data[row + start - 1][i] + " ");
            }
            return result;
        }
        if (col == 1) {
            for (int i = start; i < start + row; i++) {
                result.append(data[i][start + col - 1] + " ");
            }
            return result;
        }
        //取左边的元素
        for (int i = start; i < start + row - 1; i++) {
            result.append(data[i][start] + " ");
        }
        //取下面的元素
        for (int i = start; i < start + col - 1; i++) {
            result.append(data[start + row - 1][i] + " ");
        }
        //取右边的元素
        if (start + col - 1 != start)
            for (int i = start + row - 1; i > start; i--) {
                result.append(data[i][start + col - 1] + " ");
            }
        //取上面的的元素
        if (start + row - 1 != start)
            for (int i = start + col - 1; i > start; i--) {
                result.append(data[start][i] + " ");
            }
        return result;
    }
}
