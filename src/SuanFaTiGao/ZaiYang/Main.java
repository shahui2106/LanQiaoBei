package SuanFaTiGao.ZaiYang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-02-14 15:34
 */
public class Main {
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<int[]> allData = new ArrayList<int[]>();
        for (int j = 0; j < T; j++) {
            int M = sc.nextInt();
            int n = sc.nextInt();
            int[] data = new int[n + 1];
            data[0] = M;
            for (int i = 1; i < data.length; i++) {
                data[i] = sc.nextInt();
            }
            allData.add(data);
        }
//        perum(data,0,data.length-1,bound);
//        System.out.println(minValue);
        for (int[] allDatum : allData) {
            int[] bound = new int[allDatum[0] + 1];
//            minValue = Integer.MAX_VALUE;
            perum(allDatum, 1, allDatum.length - 1, bound);
//            System.out.println(minValue);
        }

    }

    /**
     * f(n) = f(n-1) + min(table[i])
     * 20 3
     * 3 6 14
     *
     * @param data
     * @param n
     */
    private static void f(int[] data, int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        for (int i = 1; i < table.length; i++) {
            int min = Integer.MAX_VALUE;
            int tmp = 0;
            for (int i1 = 0; i1 < data.length; i1++) {
                int chocolateNum = 0;
                if (data[i1] != 0)
//                    chocolateNum = getChocolateNum(data[i1]);
                    if (chocolateNum != 0 && chocolateNum < min) {
                        min = chocolateNum;
                        tmp = i1;
                    }
            }
            data[tmp] = 0;
//            bound[data[tmp]] = 1;
            table[i] = table[i - 1] + min;
        }
    }


    public static int getChocolateNum(int[] bound, int index) {
        int count = 0;
        for (int i = index + 1; i < bound.length; i++) {
            if (bound[i] == 0)
                count++;
            else break;
        }
        for (int i = index - 1; i > 0; i--) {
            if (bound[i] == 0)
                count++;
            else
                break;
        }
        return count;
    }


    // 对数组arr进行全排列
    public static void perum(int[] arr, int p, int q, int[] bound) {
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if (p == q) {
            System.out.println(Arrays.toString(arr));
//            int count = 0;
//            for (int i = 1; i < arr.length; i++) {
//                count += getChocolateNum(bound,arr[i]);
//                bound[arr[i]] = 1;
//            }
//            for (int i = 0; i < bound.length; i++) {
//                bound[i] = 0;
//            }
//            minValue = Math.min(count,minValue);
        }
        for (int i = p; i <= q; i++) {
            swap(arr, i, p);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q, bound);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr, i, p);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        // 交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
