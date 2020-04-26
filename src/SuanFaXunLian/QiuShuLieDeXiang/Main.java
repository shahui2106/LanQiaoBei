package SuanFaXunLian.QiuShuLieDeXiang;

/**
 * 算法训练 -- 求数列的项
 *
 * @author Zhu
 * @createtime 2020/4/26-19:31
 */
public class Main {
    public static void main(String[] args) {
        int[] data = f(20);
        for (int i = 1; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private static int[] f(int length) {
        int[] table = new int[length + 1];
        if (length <= 0)
            return null;
        if (length == 1) {
            table[1] = 1;
            return table;
        }
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i < table.length; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table;
    }
}
