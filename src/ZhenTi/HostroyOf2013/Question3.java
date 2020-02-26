package ZhenTi.HostroyOf2013;

/**
 * 2013年省赛真题2：
 * 小明从下方的“从”字开始到“华”字结束一共有多少种路径？
 * <p>
 * 从我做起振
 * 我做起振兴
 * 做起振兴中
 * 起振兴中华
 *
 * @author zhu
 * @datetime 2020-02-25 16:50
 */
public class Question3 {
    public static void main(String[] args) {
        //table[n][m] = table[n][m-1] + table[n-1][m];
        int[][] table = new int[4][5];
        table[0][0] = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = table[i][j - 1] + table[i - 1][j];
                }
            }
        }
        System.out.println(table[3][4]);
    }
}
