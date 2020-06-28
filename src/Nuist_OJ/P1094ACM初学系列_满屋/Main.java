package Nuist_OJ.P1094ACM初学系列_满屋;

import java.util.Scanner;
import java.util.Stack;

/**
 * OJ系统练习题 -- [ACM]初学系列 满屋
 *
 * @author Zhu
 * @createtime 2020/6/28-16:56
 */
public class Main {
    public static int[][] fx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static char[] fx2 = {'N', 'S', 'E', 'W'};
    public static boolean isFull = false;
    public static Stack<Integer> vec = new Stack<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] room = new int[n][n];
            int cnt = 0;
            isFull = false;
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    room[i][j] = sc.nextInt();
                    if (room[i][j] != 0)
                        cnt++;
                }
            }

            for (int i = 0; i < room.length; i++) {
                if (isFull) break;
                for (int j = 0; j < room[i].length; j++) {
                    if (room[i][j] == 0) {
                        room[i][j] = 2;
                        String res = dfs(room, i, j, cnt + 1);
                        room[i][j] = 0;
                        if (isFull) {
                            System.out.println((i + 1) + " " + (j + 1));
                            for (int l = 0; l < vec.size(); l++) {
                                res += fx2[vec.get(l)];
                            }
                            System.out.println(res);
                            while (vec.size() > 0)
                                vec.pop();
                        }
                    }
                }
            }
        }
    }

    private static boolean check(int[][] room, int i, int j) {
        int n = room.length;
        if (i < 0 || i >= n || j < 0 || j >= n || room[i][j] != 0)
            return false;
        else
            return true;
    }

    private static String f(int[][] room, int i, int j) {
        String res = "";
        int n = room.length;
        if (i - 1 >= 0 && room[i - 1][j] == 0) {
            res += "N";
            do {
                room[i][j] = 1;
                i--;
            } while (i - 1 >= 0 && room[i - 1][j] == 0);
            res += f(room, i, j);
        } else if (i + 1 < n && room[i + 1][j] == 0) {
            res += "S";
            do {
                room[i][j] = 1;
                i++;
            } while (i + 1 < n && room[i + 1][j] == 0);
            res += f(room, i, j);
        } else if (j + 1 < n && room[i][j + 1] == 0) {
            res += "E";
            do {
                room[i][j] = 1;
                j++;
            } while (j + 1 < n && room[i][j + 1] == 0);
            res += f(room, i, j);
        } else if (j - 1 >= 0 && room[i][j - 1] == 0) {
            res += "W";
            do {
                room[i][j] = 1;
                j--;
            } while (j - 1 >= 0 && room[i][j - 1] == 0);
            res += f(room, i, j);
        }
        return res;
    }

    public static String dfs(int[][] room, int x, int y, int cnt) {
        int n = room.length;
        if (cnt == n * n) {
            isFull = true;
            return "";
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + fx[i][0], yy = y + fx[i][1];
            int k = 0;
            while (check(room, xx, yy)) {
                k++;
                room[xx][yy] = 2;
                xx = xx + fx[i][0];
                yy = yy + fx[i][1];
            }
            xx = xx - fx[i][0];
            yy = yy - fx[i][1];

            if (k == 0) continue;

            vec.push(i);
            dfs(room, xx, yy, cnt + k); //向下搜索.
            if (isFull) {
                return "";
            }// 搜到最后回家
            //没搜到最后,复原
            vec.pop();
            for (int j = 1; j <= k; j++) {
                room[xx][yy] = 0;
                xx = xx - fx[i][0];
                yy = yy - fx[i][1];
            }
        }
        return "";
    }

}
