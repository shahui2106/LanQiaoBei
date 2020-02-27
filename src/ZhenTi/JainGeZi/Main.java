package ZhenTi.JainGeZi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/19-15:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //行数
        int n = sc.nextInt();
        //列数
        int m = sc.nextInt();
        //数据
        int[][] data = new int[n][m];
        //数据总和
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = sc.nextInt();
                sum += data[i][j];
            }
        }


        System.out.println(sum);
    }
}
