package SuanFaXunLian.YiDeLianTongShu;

import java.util.Scanner;

/**
 * 算法训练 -- 与1连通的点的个数
 *
 * @author Zhu
 * @createtime 2020/4/25-16:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//点的个数
        int m = sc.nextInt();//边的个数
        int ans = 0;
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            join(arr, sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < arr.length; i++) {
            if (find(arr, i) == 1)
                ans++;
        }
        System.out.println(ans);

    }

    //查询根节点
    public static int find(int[] arr, int data) {
        if (arr[data] != data) {
            if (data == 1) {
                arr[find(arr, arr[data])] = 1;
            } else
                arr[data] = find(arr, arr[data]);
        }
        return arr[data];
    }

    //加入并查集
    public static void join(int[] arr, int data1, int data2) {
        int p = find(arr, data1);
        int q = find(arr, data2);
        if (p != q) {
            if (q == 1)
                arr[p] = q;
            else
                arr[q] = p;
        }
    }
}
