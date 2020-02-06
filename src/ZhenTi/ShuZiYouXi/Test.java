package ZhenTi.ShuZiYouXi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-01-23 14:49
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //一共有多少人
        int k = sc.nextInt(); //边界
        int T = sc.nextInt();//个数
        int[] data = new int[k];
        int temp = 0;//每次加一
        int num = 1; //当前数的数字
        long sum = 0; //栋栋报的所有数之和

        //找出重复出现数字的集合
        for (int i = 0; i < k; i++) {
            data[i] = num;
            temp++;
            num += temp;
            num = num % k;
        }

        int j = 0;
        if (k % 2 == 1) {
            while (T > 0) {
                sum += data[(n * j) % k];
                j++;
                T--;
            }
        } else {
            while (T > 0) {
                int tail = (n * j) % (2 * k);
                if (tail >= k)
                    sum += data[k - (tail - k) - 1];
                else
                    sum += data[tail];
                j++;
                T--;
            }
        }
        System.out.println(sum);
    }
}