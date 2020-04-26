package SuanFaXunLian.Qiu1000YiNeiDeWanShu;

/**
 * 算法训练 -- 求1000以内的完数
 *
 * @author Zhu
 * @createtime 2020/4/26-19:40
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            if (i == getYinSum(i))
                System.out.println(i);
        }
    }

    private static int getYinSum(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
