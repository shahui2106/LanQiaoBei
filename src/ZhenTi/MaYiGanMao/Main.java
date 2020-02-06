package ZhenTi.MaYiGanMao;

import java.util.Scanner;

/**
 * 历史真题 -- 蚂蚁感冒
 *
 * @author zhu
 * @datetime 2020-02-04 14:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //蚂蚁的个数
        int n = sc.nextInt();
        //蚂蚁在竹竿相对于最左边的位置
        int[] datas = new int[n];
        for (int i = 0; i < n; i++) {
            datas[i] = sc.nextInt();
        }
        //记录已经感冒的蚂蚁
        StringBuilder ganmao = new StringBuilder();
        //已知第一个位置的蚂蚁感冒
        ganmao.append(0);

        /*
         * 每次循环将所有蚂蚁前进一步，并判断是否遇到了感冒的蚂蚁
         * 若遇到了，将入到ganmao字符集中
         * 若没有遇到，继续前进
         */
        int count = 0;
        while (count < n) {
            count = 0;
            for (int i = 0; i < n; i++) {
                //记录蚂蚁离开的数目
                if (datas[i] == 0 || datas[i] >= 100) {
                    count++;
                    continue;
                }
                datas[i]++;
                if (!ganmao.toString().contains("" + i)) {
                    int length = ganmao.length();
                    for (int j = 0; j < length; j++) {
                        /*
                         *  此下两种情况会发生感冒：
                         *  1、蚂蚁的坐标和已经感冒的蚂蚁坐标相等，例如： 1 和 -3，各加一
                         *  2、未感冒的蚂蚁各感冒的蚂蚁相对距离为1，例如： 1 和 -2， 各加一会相交返回变成 -1 和 2
                         */
                        if (Math.abs(datas[getGanMao(ganmao, j)]) == Math.abs(datas[i]) ||
                                Math.abs(datas[getGanMao(ganmao, j)] + datas[i]) == 1) {
                            if (!ganmao.toString().contains("" + i)) {
                                ganmao.append(i);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ganmao.length());
    }

    /**
     * 获取已经感冒的蚂蚁的坐标
     *
     * @param ganmao 已经感冒蚂蚁的字符集合
     * @param j      要获取的坐标
     * @return 此坐标上的值
     */
    private static int getGanMao(StringBuilder ganmao, int j) {
        return Integer.parseInt(ganmao.substring(j, j + 1));
    }
}
