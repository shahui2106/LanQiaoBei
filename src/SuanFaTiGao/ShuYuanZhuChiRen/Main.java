package SuanFaTiGao.ShuYuanZhuChiRen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法提高 -- 书院主持人
 *
 * @author zhu
 * @datetime 2020-02-05 11:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一共有m个人
        int m = sc.nextInt();
        //报到数n的失去主持人的资格
        int n = sc.nextInt();

        boolean[] datas = new boolean[m + 1];
        //第i个人报数
        int i = 0;
        //第i个人报的数num
        int num = 0;
        //已经报过数的人数
        int count = 0;
        while (true) {
            i++;
            if (i >= datas.length) {
                i = 1;
            }
            if (!datas[i]) {
                num++;
            } else {
                continue;
            }
            if (num % n == 0) {
                num = 0;
                datas[i] = true;
                count++;
            }
            if (count == m - 1) {
                break;
            }
        }
        //获取那个唯一没有报到数字n的那个人
        for (int i1 = 1; i1 < datas.length; i1++) {
            if (!datas[i1]) {
                System.out.println(i1);
                break;
            }
        }
    }
}
