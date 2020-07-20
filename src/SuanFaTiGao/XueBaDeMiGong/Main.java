package SuanFaTiGao.XueBaDeMiGong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 算法提高 -- 学霸的迷宫
 *
 * @author Zhu
 * @createtime 2020/7/20-10:51
 */
public class Main {
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static String[] fx = {"U", "D", "L", "R"};
    private static List<Point> queue = new ArrayList<Point>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] Matrix = new int[n + 1][m + 1];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            char[] temp = sc.nextLine().toCharArray();
            for (int j = 0; j < temp.length; j++) {
                Matrix[i + 1][j + 1] = temp[j] - '0';
            }
        }
        bsf(Matrix);
    }

    private static void bsf(int[][] matrix) {
        Point begin = new Point(1, 1, 0, "");//新建一个起点
        queue.add(begin);
        int minStep = Integer.MAX_VALUE;//记录最小路径
        String minPath = ""; //记录字典序最小的路径

        while (queue.size() != 0) {
            Point point = queue.get(0);
            queue.remove(0);

            //到这说明已经到了终点
            if (point.x == matrix.length - 1 && point.y == matrix[0].length - 1) {
                if (point.step < minStep) {
                    minStep = point.step;
                    minPath = point.path;
                } else if (point.step == minStep) {
                    minPath = getMinPath(minPath, point.path);
                }
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = point.x + move[i][0];
                int y = point.y + move[i][1];
                int step = point.step + 1;
                String path = point.path + fx[i];
                Point nextPoint = new Point(x, y, step, path);
                if (check(matrix, nextPoint)) {
                    queue.add(nextPoint);
                    matrix[x][y] = 1;
                }
            }
        }
        System.out.println(minStep);
        System.out.println(minPath);
    }


    private static String getMinPath(String path1, String path2) {
        return path1.compareTo(path2) < 0 ? path1 : path2;
    }

    private static boolean check(int[][] matrix, Point nextPoint) {
        if (nextPoint.x < 1 || nextPoint.y < 1 || nextPoint.x >= matrix.length || nextPoint.y >= matrix[0].length || matrix[nextPoint.x][nextPoint.y] == 1)
            return false;
        return true;
    }

    static class Point {
        private int x;
        private int y;
        private int step;
        private String path;

        public Point(int x, int y, int step, String path) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", step=" + step +
                    ", path='" + path + '\'' +
                    '}';
        }
    }
}
