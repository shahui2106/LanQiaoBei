package JiChuTi.ShiJianZhuanHuan;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/18-14:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入秒值
        int t = sc.nextInt();
        //时
        int hour = 0;
        //分
        int min = 0;
        //秒
        int second = 0;

        min = t / 60;
        hour = min / 60;
        min = min % 60;
        second = t % 60;

        System.out.println(hour + ":" + min + ":" + second);
    }
}
