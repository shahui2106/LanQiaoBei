package SuanFaXunLian.BaoShu;

import java.util.Scanner;

/**
 * 算法训练 -- 报数
 *
 * @author Zhu
 * @createtime 2020/5/2-16:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n + 1];
        //当前所报的数
        int num = 0;
        //指针
        int i = 0;
        //出去的人数
        int remove = 0;
        while (true) {
            num++;
            if (num == 3)
                num = 1;
            i++;
            if (i == data.length) {
                i = 1;
            }
            while (data[i] != 0) {
                i++;
                if (i == data.length) {
                    i = 1;
                }
            }
            if (num == 2) {
                data[i] = 1;
                remove++;
            }
            if (remove == data.length - 2)
                break;
        }
        for (int j = 1; j < data.length; j++) {
            if (data[j] == 0) {
                System.out.println(j);
                break;
            }
        }
    }
}
