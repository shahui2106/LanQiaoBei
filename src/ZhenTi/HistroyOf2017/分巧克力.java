package ZhenTi.HistroyOf2017;

import java.util.Scanner;
import java.util.WeakHashMap;

/**
 * 标题： 分巧克力
 * <p>
 * 儿童节那天有K位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。
 * 小明一共有N块巧克力，其中第i块是Hi x Wi的方格组成的长方形。
 * <p>
 * 为了公平起见，小明需要从这 N 块巧克力中切出K块巧克力分给小朋友们。切出的巧克力需要满足：
 * 1. 形状是正方形，边长是整数
 * 2. 大小相同
 * <p>
 * 例如一块6x5的巧克力可以切出6块2x2的巧克力或者2块3x3的巧克力。
 * <p>
 * 当然小朋友们都希望得到的巧克力尽可能大，你能帮小Hi计算出最大的边长是多少么？
 * <p>
 * 输入
 * 第一行包含两个整数N和K。(1 <= N, K <= 100000)
 * 以下N行每行包含两个整数Hi和Wi。(1 <= Hi, Wi <= 100000)
 * 输入保证每位小朋友至少能获得一块1x1的巧克力。
 * <p>
 * 输出
 * 输出切出的正方形巧克力最大可能的边长。
 * <p>
 * 样例输入：
 * 2 10
 * 6 5
 * 5 6
 * <p>
 * 样例输出：
 * 2
 *
 * @author Zhu
 * @createtime 2020/3/7-19:20
 */
public class 分巧克力 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] Hi = new int[N];
        int[] Wi = new int[N];

        for (int i = 0; i < N; i++) {
            Hi[i] = sc.nextInt();
            Wi[i] = sc.nextInt();
        }


        int l = 0;
        int r = 100000;
        int ans = 0;
        while (l < r) {
            int scnt = 0;
            int mid = (l + r) / 2;

            for (int i = 0; i < N; i++) {
                scnt += (Hi[i] / mid) * (Wi[i] / mid);
            }

            if (scnt >= K) {
                l = mid + 1;
                ans = mid;
            } else
                r = mid - 1;
        }

        System.out.println("ans = " + ans);
    }
}
