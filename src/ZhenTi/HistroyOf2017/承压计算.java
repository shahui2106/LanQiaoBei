package ZhenTi.HistroyOf2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/3/7-15:01
 */
public class 承压计算 {
    public static void main(String[] args) {
        long[][] data = new long[30][30];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j <= i; j++) {
                data[i][j] = sc.nextLong();
                data[i][j] = (long) (data[i][j] * Math.pow(2, 30));
            }
        }

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                data[i + 1][j] += data[i][j] / 2;
                data[i + 1][j + 1] += data[i][j] / 2;
            }
        }

        for (long[] datum : data) {
            Arrays.sort(datum);
//            System.out.println(Arrays.toString(datum));
        }
//        System.out.println(data[29][0]/2);
        System.out.println(data[29][29] / 2);

    }
}
