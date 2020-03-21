package ZhenTi.HistroyOf2017;

/**
 * 标题：纸牌三角形
 * <p>
 * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
 * 下图就是一种排法（如有对齐问题，参看p1.png）。
 * <p>
 * A        0
 * 9 6      1 2
 * 4   8    3   4
 * 3 7 5 2  5 6 7 8
 * <p>
 * 这样的排法可能会有很多。
 * <p>
 * 如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
 * <p>
 * 请你计算并提交该数字。
 * <p>
 * 注意：需要提交的是一个整数，不要提交任何多余内容。
 *
 * @author Zhu
 * @createtime 2020/3/7-21:13
 */
public class 纸牌三角形 {
    public static int ans = 0;

    // 交换函数：将数组arr中索引为i和j元素互换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 对数组arr进行全排列
    public static void perum(int[] arr, int p, int q) {
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if (p == q) {
            int a = arr[0] + arr[1] + arr[3] + arr[5];
            int b = arr[0] + arr[2] + arr[4] + arr[8];
            int c = arr[5] + arr[6] + arr[7] + arr[8];
            if (a == b && a == c)
                ans++;
        }
        for (int i = p; i <= q; i++) {
            swap(arr, i, p);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr, i, p);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        perum(data, 0, data.length - 1);
        //每六种排列算一种排列
        System.out.println(ans / 6);
    }
}
