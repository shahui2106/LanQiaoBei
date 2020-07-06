package Nuist_OJ.P1129走出泥潭;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 走出泥潭
 *
 * @author Zhu
 * @createtime 2020/7/5-19:47
 */
public class Main {
    public static int[][] fx = {{1, 0}, {0, 1}};
    public static List<String> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            StringBuilder outRes = new StringBuilder();
            res = new ArrayList<String>();
            int[][] data = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    data[i][j] = sc.nextInt();
                }
            }
            res.add("(1,1)");
            dfs(data, 0, 0, 0);
            for (int i = 0; i < res.size(); i++) {
                if (i != res.size() - 1)
                    outRes.append(res.get(i) + ">");
                else
                    outRes.append(res.get(i));
            }
            System.out.println(outRes);
        }
    }

    private static void dfs(int[][] data, int row, int col, int cnt) {
        if (cnt == (data.length + data[0].length - 2))
            return;
        for (int i = 0; i < 2; i++) {
            int x = row + fx[i][0], y = col + fx[i][1];
            if (check(data, x, y)) {
                res.add("(" + (x + 1) + "," + (y + 1) + ")");
                dfs(data, x, y, cnt + 1);
            }
        }
    }

    public static int d(int x, int y) {
        if (x == 0)
            return 1;
        return d(x - 1, y) + d(x, y - 1);
    }

    private static boolean check(int[][] data, int x, int y) {
        if (x < 0 || x >= data.length || y < 0 || y >= data[0].length || data[x][y] == 0)
            return false;
        return true;
    }
}
