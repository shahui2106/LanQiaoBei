package ZhenTi.DaYinShiZiTu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/9-9:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 1 && n < 30) {
            int l = (4 * n + 5);
            String[][] data = new String[l / 2][l / 2];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = "$";
                }
            }
            data[0][0] = ".";

            //先初始化四分之一数组的斜对角数据
            for (int i = 1; i < data.length; i++) {
                for (int j = i; j < data[i].length; j++) {
                    if (i == j && (i % 2) == 1) {
                        data[i][j] = ".";
                        data[i - 1][j] = ".";
                        if ((i - 2) > 0)
                            data[i - 2][j] = ".";
                    }
                    if((i % 2) == 1 && j > i){
                        if ((i - 2) > 0)
                        data[i-2][j] = ".";
                    }
                }
            }

            //将斜对角的数据对称过来
            for (int i = 0; i < data.length; i++) {
                for (int j = i+1; j < data[i].length; j++) {
                  data[j][i] = data[i][j];
                }
            }



            //输出上半个图形
            for (int i = 0; i < data.length; i++) {
                //输出左边图形
                for (int i1 = 0; i1 < data.length; i1++) {
                    System.out.print(data[i][i1]);
                }
                //输出中间一列
                if ((i%2) == 1 && i != data.length-1)
                    System.out.print(".");
                else
                    System.out.print("$");
                //输出右边图形
                for (int i1 = data.length-1; i1 >= 0; i1--) {
                    System.out.print(data[i][i1]);
                }
                System.out.println();
            }

            //输出中间一行
            for (int i2 = 0; i2 < data.length ; i2++) {
                if ((i2%2) == 1 && i2 != data.length-1) {
                    System.out.print(".");
                }
                else {
                    System.out.print("$");
                }
            }
            System.out.print("$");
            for (int i2 = data.length - 1; i2 >= 0; i2--) {
                if ((i2%2) == 1 && i2 != data.length-1) {
                    System.out.print(".");
                }
                else {
                    System.out.print("$");
                }
            }
            System.out.println();

            //输出下半个图形
            for (int i = data.length-1; i >= 0; i--) {
                //输出左边图形
                for (int i1 = 0; i1 < data.length; i1++) {
                    System.out.print(data[i][i1]);
                }
                //输出中间一列
                if ((i%2) == 1 && i != data.length-1)
                    System.out.print(".");
                else
                    System.out.print("$");
                //输出右边图形
                for (int i1 = data.length - 1; i1 >= 0; i1--) {
                    System.out.print(data[i][i1]);
                }
                System.out.println();
            }
        }
    }
}
