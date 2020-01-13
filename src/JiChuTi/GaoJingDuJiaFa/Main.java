package JiChuTi.GaoJingDuJiaFa;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/12-8:57
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(function2(a, b));
    }

    //计算抽取出的两个数的加值
    public static int add(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    //方法一：利用BigInteger类直接进行计算
    private static BigInteger function1(String a, String b) {
        BigInteger bigInteger = new BigInteger(b);
        return new BigInteger(a).add(bigInteger);
    }

    //方法二：利用数组对应相加
    private static String function2(String a, String b) {
        String[] data_a = a.split("");
        String[] data_b = b.split("");
        StringBuffer result = new StringBuffer();
        int temp = 0;
        int a_length = data_a.length - 1;
        int b_length = data_b.length - 1;
        //从尾部开始一位一位的计算
        while (a_length >= 0 && b_length >= 0) {
            int add = add(data_a[a_length], data_b[b_length]);
            add += temp;
            if (add % 10 >= 0) {
                temp = add / 10;
                result.append(add % 10);
            } else {
                temp = 0;
                result.append(add);
            }
            a_length--;
            b_length--;
        }
        //如果a的值大于b的值把a剩余的数字和进位依次加入结果中
        if (data_a.length > data_b.length) {
            for (int i = data_a.length - data_b.length - 1; i >= 0; i--) {
                if (temp != 0) {
                    int add = add(data_a[i], Integer.toString(temp));
                    if (add % 10 >= 0) {
                        temp = add / 10;
                        result.append(add % 10);
                    } else {
                        temp = 0;
                        result.append(add);
                    }
                } else
                    result.append(data_a[i]);
            }
        }

        //如果b的值大于a的值把b剩余的数字和进位依次加入结果中
        if (data_a.length < data_b.length) {
            for (int i = data_b.length - data_a.length - 1; i >= 0; i--) {
                if (temp != 0) {
                    int add = add(data_b[i], Integer.toString(temp));
                    if (add % 10 >= 0) {
                        temp = add / 10;
                        result.append(add % 10);
                    } else {
                        temp = 0;
                        result.append(add);
                    }
                } else
                    result.append(data_b[i]);
            }
        }
        //如果a的值等于b的值把进位加入结果中
        if (data_a.length == data_b.length && temp != 0) {
            result.append(temp);
        }
        return result.reverse().toString();

    }
}
