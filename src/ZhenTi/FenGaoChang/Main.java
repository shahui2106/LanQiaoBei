package ZhenTi.FenGaoChang;

import java.util.Scanner;

/**
 * 历史真题 -- 分考场
 *
 * @author zhu
 * @datetime 2020-02-09 13:14
 */
public class Main {
    static boolean[][] data;
    static int[] exam;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一共有多少人
        int n = sc.nextInt();
        //人与人之间的关系数目
        int k = sc.nextInt();
        //人与人关系的集合
        data = new boolean[n + 1][n + 1];
        //每个学生的考场数
        exam = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //第a个人和第b个人认识
            data[a][b] = true;
            data[b][a] = true;
        }

        DFS(n, 1, 0);
        System.out.println(result);
    }

    /**
     * 深度优先遍历（DFS）
     * 依次为每一个学生安排考场
     *
     * @param allStudent 所有参加考试的学生
     * @param curStudent 当前安排的学生
     * @param examNum    最小考场数
     */
    private static void DFS(int allStudent, int curStudent, int examNum) {
        // 剪枝,很重要！！！
        if (examNum >= result) return;
        //所有学生都已经安排完成
        if (curStudent == allStudent + 1) {
            if (examNum < result)
                result = examNum;
            return;
        }

        //遍历每一个考场
        for (int i = 1; i <= examNum; i++) {
            //当前安排的学生能否加入此考场
            boolean isadd = true;
            for (int j = 1; j <= allStudent; j++) {
                //该考场是否有当前学生认识的人
                if (data[curStudent][j] && exam[j] == i) {
                    isadd = false;
                    break;
                }

            }
            if (isadd) {
                exam[curStudent] = i;
                //安排下一个学生
                DFS(allStudent, curStudent + 1, examNum);
                //回退操作
                exam[curStudent] = 0;
            }
        }

        //每一个考场都不能加入，分布到新的考场
        exam[curStudent] = examNum + 1;
        //安排下一个学生
        DFS(allStudent, curStudent + 1, examNum + 1);
        //回退操作
        exam[curStudent] = 0;
    }
}
