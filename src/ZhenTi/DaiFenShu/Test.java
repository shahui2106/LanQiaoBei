package ZhenTi.DaiFenShu;

import java.util.Arrays;

/**
 * @author Zhu
 * @createtime 2020/1/10-16:16
 */
public class Test {

    public static void pringArray(int[] arr, int n) {
        // 打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        // 交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 对数组arr进行全排列
    public static void perum(int[] arr, int p, int q) {
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if (p == q) {
            //  一次递归结束。将整个数组打印出来
            pringArray(arr, q + 1);
        }
        for (int i = p; i <= q; i++) {
            swap(arr, i, p);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr, i, p);
        }
    }

    /*    private static void getDaifenshu(String s, int n) {
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


        }*/
    public static void main(String[] args) {
        int[] data1 = {0, 0, 0, 1, 2, 3};
        int[] data2 = {0, 0, 0, 1, 2, 3};
        System.out.println(Arrays.equals(data1, data2));
        /*Main.sort(data);
        for (int i = 0; i < data.length; i++) {
                System.out.print(" " + data[i]);
        }*/
    }
}
