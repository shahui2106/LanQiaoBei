package ZhenTi.DaiFenShu;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/10-14:51
 */
public class Main {
    private static int num = 0;

    // 交换函数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 对数组arr进行全排列
    public static void perum(int[] arr, int p, int q, String s, int n, int length) {
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if (p == q) {
            String tmp = "";
            for (int i = 0; i < arr.length; i++) {
                tmp += arr[i];
            }
            System.out.println(tmp.length());
            System.out.println(length);
            int fenMu = Integer.parseInt(tmp.substring(0, length));
            int fenZi = Integer.parseInt(tmp.substring(length));
            System.out.println(fenMu + " " + fenZi);
            if ((n - Integer.parseInt(s)) * fenMu == fenZi)
                num++;
        }
        for (int i = p; i <= q; i++) {
            swap(arr, i, p);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q, s, n, length);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr, i, p);
        }
    }

    //将数字从小到大排序
    public static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int i1 = 1; i1 < data.length - i; i1++) {
                if (data[i1 - 1] > data[i1]) {
                    int tmp = data[i1 - 1];
                    data[i1 - 1] = data[i1];
                    data[i1] = tmp;
                }
            }
        }
    }

    //判断整数部分是否有重复的数字
    public static boolean isRepeat(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0 && n < 1000000) {
            for (int i = n - 2; i > 0; i--) {
                String s = Integer.toString(i);
                //如果整数部分包含零，就判断下一个
                if (s.contains("0"))
                    continue;
                //如果整数部分有重复的数字，就判断下一个
                if (isRepeat(s))
                    continue;
                //获取此整数下的所有分数的可能个数
                getDaifenshu(s, n);
            }
        }
        System.out.println(num);
    }

    private static void getDaifenshu(String s, int n) {
        int fenZi = 0;
        int fenMu = 0;
        int length = 9;
        int[] data = new int[9];
        int[] datatest = new int[9];
        //初始化数组1-9
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        //去除整数部分的数字
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (data[i] == Integer.parseInt(s.substring(0, j + 1))) {
                    data[i] = 0;
                    length--;                //2 <= length <= 8
                }
            }
        }
        //对数组进行从小到大重新排序
        sort(data);

        for (int i = 9 - length; i < data.length; i++) {
            fenMu = data[i];
            fenZi = (n - Integer.parseInt(s)) * fenMu;
            datatest[0] = fenMu;
            int j = 1;
            while (fenZi % 10 > 0) {
                datatest[j] = fenZi % 10;
                fenZi = fenZi / 10;
                j++;
                if (j == datatest.length)
                    break;
            }
            if (Arrays.equals(data, datatest))
                num++;
        }


        for (int i = 9 - length; i < data.length; i++) {
            fenMu = data[i] * 10;
            datatest[0] = data[i];
            for (int l = 9 - length; l < data.length; l++) {
                if (l != i) {
                    fenMu += data[l];
                    fenZi = (n - Integer.parseInt(s)) * fenMu;
                    datatest[1] = data[l];
                    int j = 2;
                    while (fenZi % 10 > 0) {
                        datatest[j] = fenZi % 10;
                        fenZi = fenZi / 10;
                        j++;
                        if (j == datatest.length)
                            break;
                    }
                    if (Arrays.equals(data, datatest))
                        num++;
                }
            }

        }
        fenMu = 0;
        fenZi = 0;


        for (int i = 9 - length; i < data.length; i++) {
            fenMu = data[i] * 100;
            datatest[0] = data[i];
            for (int l = 9 - length; l < data.length; l++) {
                if (l != i) {
                    fenMu += data[l] * 10;
                    datatest[1] = data[l];
                    for (int k = 9 - length; k < data.length; k++) {
                        if (k != l && k != i) {
                            fenMu += data[k];
                            datatest[2] = data[k];
                            fenZi = (n - Integer.parseInt(s)) * fenMu;
                            System.out.println("fenMu = " + fenMu);
                            System.out.println("fenZi = " + fenZi);
                            int j = 3;
                            while (fenZi % 10 > 0) {
                                datatest[j] = fenZi % 10;
                                fenZi = fenZi / 10;
                                j++;
                                if (j == datatest.length) {
                                    break;
                                }
                            }
                            System.out.println(Arrays.toString(datatest));
                            if (Arrays.equals(data, datatest))
                                num++;

                        }
                    }


                }
            }

        }


    }
}
