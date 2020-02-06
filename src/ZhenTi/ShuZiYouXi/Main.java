package ZhenTi.ShuZiYouXi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-01-23 14:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //一共有多少人
        int k = sc.nextInt(); //边界
        int T = sc.nextInt();//个数
        List<Integer> data = new ArrayList<>();

        int temp = 0;//每次加一
        int num = 1; //当前数的数字
        long sum = 0; //栋栋报的所有数之和

        //找出重复出现数字的集合
        for (int i = 0; i < k; i++) {
            data.add(num);
            temp++;
            num += temp;
            num = num % k;
        }

        if (k % 2 == 1) {
            int index = 0;
            while (T > 0) {
                sum += data.get(index);
                T--;
                index += n;
                index = index % k;
            }
        } else {
            int tail = 0;
            while (T > 0) {
                if (tail >= k) {
                    sum += data.get(k - (tail - k) - 1);
                } else {
                    sum += data.get(tail);
                }
                T--;
                tail += n;
                tail = tail % (2 * k);
            }
        }
        System.out.println(sum);
    }
}