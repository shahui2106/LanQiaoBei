package SuanFaXunLian.KuaiSuPaiXu;

import java.util.Scanner;

/**
 * 算法训练 -- 快速排序
 * <p>
 * 还需继续优化，当数据本来就是有序的而且数据量很大时，存在栈溢出
 *
 * @author Zhu
 * @createtime 2020/4/5-19:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        quickSort(data, 0, data.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }

    //快速排序
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        //将第一个位置定义为主元
        int ele = getMidValue(arr, startIndex, endIndex);
        //主元的下一个为左指针
        int left = startIndex + 1;
        int equals = startIndex + 1;
        //最后一个元素的下标为右指针
        int right = endIndex;

        while (left <= right) {
            //左边的元素比主元小，左指针右移，直到出现第一个比主元大的元素
            while (left <= endIndex && arr[left] <= ele) {
                if (arr[left] < ele) {
                    swap(arr, left, equals);
                    equals++;
                }
                left++;
            }
            //右边的元素比主元大，右指针左移，直到出现第一个比主元小的元素
            while (right >= startIndex && arr[right] > ele) {
                right--;
            }
            if (left < right)
                //将左边大的和右边小的进行交换
                swap(arr, left, right);
        }
        swap(arr, startIndex, --equals);

        //把左边的在进行快速排序
        quickSort(arr, startIndex, equals - 1);
        //右边的在进行快速排序
        quickSort(arr, right + 1, endIndex);
    }

    private static int getMidValue(int[] arr, int startIndex, int endIndex) {
        int mid = startIndex;
        int midIndex = startIndex + ((endIndex - startIndex) >> 1);
        if (arr[mid] < arr[midIndex]) {
            mid = midIndex;
        }
        if (arr[mid] > arr[endIndex]) {
            if (mid == startIndex) {
                mid = arr[midIndex] > arr[endIndex] ? midIndex : endIndex;
            } else {
                mid = arr[startIndex] > arr[endIndex] ? startIndex : endIndex;
            }
        }
        swap(arr, startIndex, mid);
        return arr[startIndex];
    }

    //将数组中的两个元素进行交换
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
