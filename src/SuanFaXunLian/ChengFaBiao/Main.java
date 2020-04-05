package SuanFaXunLian.ChengFaBiao;

/**
 * 算法训练 -- 乘法表
 *
 * @author Zhu
 * @createtime 2020/4/5-20:09
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
    }
}
