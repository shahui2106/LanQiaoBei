package ZhenTi.XiaoPengYouPaiDui;

import java.util.Scanner;

/**
 * 历史真题 -- 小朋友排队
 *
 * @author zhu
 * @datetime 2020-01-26 13:37
 */
public class Main {

    /**
     * 冒泡排序
     * 并记录每个位置交换的次数
     *
     * @param data  需排序的数组
     * @param upset 记录每个位置交换次数的数组
     */
    private static void sort(int[] data, int[] upset) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j]) {
                    swrap(data, j - 1, j);
                    upset[j - 1]++;
                    upset[j]++;
                    swrap(upset, j - 1, j);
                }
            }
        }
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param a 位置1
     * @param b 位置2
     */
    public static void swrap(int[] data, int a, int b) {
        data[a] = data[a] ^ data[b];
        data[b] = data[a] ^ data[b];
        data[a] = data[a] ^ data[b];
    }

    /**
     * 通过交换次数求得此小朋友的不高兴程度
     *
     * @param count 交换次数
     * @return 不高兴程度
     */
    public static long getUpsetSum(int count) {
        return ((1 + count) * count) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //有多少个小朋友
        int n = sc.nextInt();
        //所有小朋友身高的数据
        int[] data_height = new int[n];
        //所有小朋友不高兴的数据
        int[] data_upset = new int[n];
        for (int i = 0; i < data_height.length; i++) {
            data_height[i] = sc.nextInt();
        }

        //所有小朋友不高兴程度之和
        long sum = 0;
        sort(data_height, data_upset);
        for (int i = 0; i < data_upset.length; i++) {
            sum += getUpsetSum(data_upset[i]);
        }
        System.out.println(sum);
    }

}