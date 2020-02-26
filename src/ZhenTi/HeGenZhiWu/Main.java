package ZhenTi.HeGenZhiWu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 历史真题 -- 合根植物
 *
 * @author zhu
 * @datetime 2020-02-08 12:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //行
        int m = sc.nextInt();
        //列
        int n = sc.nextInt();
        //合根关系数目
        int k = sc.nextInt();
        //合根关系集合
        String[] relations = new String[k + 1];
        for (int i = 0; i <= k; i++) {
            relations[i] = sc.nextLine();
        }
        //合根并查集
        int[] datas = new int[(m * n) + 1];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = i;
        }

        for (int i = 1; i < relations.length; i++) {
            String[] relation = relations[i].split(" ");
            int num1 = Integer.parseInt(relation[0]);
            int num2 = Integer.parseInt(relation[1]);
            join(datas, num1, num2);
        }

        //压缩路径
        for (int i = 0; i < datas.length; i++) {
            FindToXH(datas, i);
        }

        //利用set集合的无重复性统计并查集根结点的个数
        Set<Integer> top = new HashSet<Integer>();
        for (int i = 1; i < datas.length; i++) {
            top.add(datas[i]);
        }

        System.out.println(top.size());


    }

    /**
     * 路径压缩（递归），并查找出此数在此并集中的根节点
     *
     * @param data 集合
     * @param x    需要的查找的数
     * @return 此数的根节点
     */
    public static int FindToDG(int[] data, int x) {
        if (data[x] != x)
            data[x] = FindToDG(data, data[x]);
        return data[x];
    }

    /**
     * 路径压缩（循环），并查找出此数在此并集中的根节点
     *
     * @param data 集合
     * @param x    需要的查找的数
     * @return 此数的根节点
     */
    public static int FindToXH(int[] data, int x) {
        int p, tmp;
        p = x;
        while (x != data[x]) {
            x = data[x];
        }
        while (p != x) {
            tmp = data[p];
            data[p] = x;
            p = tmp;
        }
        return x;
    }

    /**
     * 加入某个并集中
     *
     * @param datas 集合
     * @param x     数字1
     * @param y     数字2
     */
    public static void join(int[] datas, int x, int y) {
        int p = FindToXH(datas, x);
        int q = FindToXH(datas, y);
        if (p != q) datas[p] = q;
    }
}
