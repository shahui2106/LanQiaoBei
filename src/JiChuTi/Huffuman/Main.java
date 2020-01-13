package JiChuTi.Huffuman;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/12-15:27
 */
public class Main {
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

    //获取排序后前面两个最小值的和并把和值放入此数组中
    public static int getMinSumValue(int[] data, int start) {
        int min = data[start];
        int min2 = data[start + 1];
        data[start] = -1;
        data[start + 1] = min + min2;
        return min + min2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < data.length - 1; i++) {
            sort(data);
            sum += getMinSumValue(data, i);
        }
        System.out.println(sum);
    }
}
