package SuanFaXunLian.JiNianPinFenZu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法训练 -- 纪念品分组
 *
 * @author Zhu
 * @createtime 2020/7/30-12:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        //用来存放价值为w的容器
        int[] path = new int[n];
        //标记容器中放入了几个纪念品
        int[] flag = new int[n];
        //数据来源，即物品的价值
        int[] data = new int[n];
        //初始化容器
        Arrays.fill(path, w);
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        for (int i = data.length - 1; i >= 0; i--) {
            for (int i1 = 0; i1 < path.length; i1++) {
                //如果此容器放入纪念品的个数小于2，且还可以继续放入，则继续放入该纪念品
                if (flag[i1] < 2 && data[i] <= path[i1]) {
                    path[i1] -= data[i];
                    flag[i1]++;
                    break;
                }
            }
        }

        int res = 0;
        for (int i : path) {
            //如果此容器的价值不等于初始价值，则表示有物品放入
            if (i != w)
                res++;
            else break;
        }
        System.out.println(res);
    }
}
