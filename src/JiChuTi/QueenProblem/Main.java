package JiChuTi.QueenProblem;

import java.util.*;

/**
 * @author Zhu
 * @createtime 2020/1/13-18:37
 */
public class Main {
    //记录一共有多少可能
    static int num = 0;
    //queen[i] 表示第i个皇后的位置
    static int[] queen;
    //记录所有n皇后所有可能的结果
    static List<int[]> result;

    /**
     * 检查当前列能否放置皇后，不能放返回false，能放放回true
     *
     * @param j 当前列
     * @return 是否能放置
     */
    public static boolean place(int j) {
        for (int i = 1; i < j; i++) {
            //在同一列或者斜对角都不可以放置
            if (queen[i] == queen[j] || Math.abs(queen[i] - queen[j]) == (j - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 皇后放置策略
     *
     * @param data 棋盘数据
     * @param j    从第j个开始放
     * @param n    皇后的个数
     */
    public static void Nqueen(int[][] data, int j, int n) {
        for (int i = 1; i <= n; i++) {
            queen[j] = i;
            if (place(j)) {
                if (j == n) {
                    boolean isZero = false;
                    for (int i1 = 1; i1 < queen.length; i1++) {
                        //判断棋盘此位置是否能放置
                        if (data[i1 - 1][queen[i1] - 1] == 0) {
                            isZero = true;
                            break;
                        }
                    }
                    if (!isZero) {
                        //将此种可能放入结果集合中
                        int[] tempdata = new int[queen.length];
                        for (int i1 = 0; i1 < tempdata.length; i1++) {
                            tempdata[i1] = queen[i1];
                        }
                        result.add(tempdata);
                    }
                } else {
                    Nqueen(data, j + 1, n);
                }
            }
        }
    }

    /**
     * 判断两个数组中是否有对应相等的元素
     *
     * @param data1 数组1
     * @param data2 数组2
     * @return 只要有一个对应相等的元素就放回true, 否则放回false
     */
    private static boolean ishasequal(int[] data1, int[] data2) {
        for (int i = 1; i < data1.length; i++) {
            if (data1[i] == data2[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        queen = new int[n + 1];
        int[][] data = new int[n][n];
        result = new LinkedList<>();
        //初始化棋盘数据
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data.length; i1++) {
                data[i][i1] = sc.nextInt();
            }
        }
        Nqueen(data, 1, n);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                if (j != i) {
                    if (!ishasequal(result.get(i), result.get(j))) {
                        num++;
                    }
                }
            }
        }
        System.out.println(num);
    }


}
