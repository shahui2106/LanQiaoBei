package MoNiSai_2020.p9;

import java.util.Scanner;

/**
 * 编程题9：
 * 问题描述
 * 　　小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
 * 　　小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
 * 　　这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。
 * 　　请告诉小明，k 个月后空地上哪些地方有草。
 * 输入格式
 * 　　输入的第一行包含两个整数 n, m。
 * 　　接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。
 * 　　接下来包含一个整数 k。
 * 输出格式
 * 　　输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草。
 * 样例输入
 * 4 5
 * .g...
 * .....
 * ..g..
 * .....
 * 2
 * 样例输出
 * gggg.
 * gggg.
 * ggggg
 * .ggg.
 *
 * @author Zhu
 * @createtime 2020/3/22-11:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] data = new char[n + 1][m];
        boolean[][] tag = new boolean[n + 1][m];
        for (int i = 0; i <= n; i++) {
            data[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (i > 0 && data[i][j] == 'g')
                    tag[i][j] = true;
            }
        }
        int k = sc.nextInt();
        sc.close();
        for (int i = 1; i < tag.length; i++) {
            for (int j = 0; j < tag[i].length; j++) {
                if (tag[i][j]) {
                    f(data, i, j, k);
                }
            }
        }

        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

    private static void f(char[][] data, int x, int y, int k) {
        if (k == 0)
            return;
        if (x >= 2) {
            data[x - 1][y] = 'g';
            f(data, x - 1, y, k - 1);
        }
        if (x < data.length - 1) {
            data[x + 1][y] = 'g';
            f(data, x + 1, y, k - 1);
        }
        if (y < data[x].length - 1) {
            data[x][y + 1] = 'g';
            f(data, x, y + 1, k - 1);
        }
        if (y >= 1) {
            data[x][y - 1] = 'g';
            f(data, x, y - 1, k - 1);
        }
    }
}
