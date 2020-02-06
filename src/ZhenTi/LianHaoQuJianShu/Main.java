package ZhenTi.LianHaoQuJianShu;

import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-01-22 16:29
 */
public class Main {
    //连号区间的个数
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数的规模
        int N = sc.nextInt();
        int[] data = new int[N];
        //初始化数据，1~N中的某一个全排列
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }

        for (int i = 0; i < data.length; i++) {
            handle(data, i);
        }

        System.out.println(count);

    }

    private static void handle(int[] data, int start) {
        int max = data[start];
        int min = data[start];
        count++;
        for (int i = start + 1; i < data.length; i++) {
            if ((max - min) == i - start || Math.abs(data[i] - min) <= 1 || Math.abs(data[i] - max) <= 1) {
                for (int j = start; j <= i; j++) {
                    if (data[j] > max)
                        max = data[j];
                    if (data[j] < min)
                        min = data[j];
                }
                if ((max - min) == i - start)
                    count++;
            }
        }
    }
}
