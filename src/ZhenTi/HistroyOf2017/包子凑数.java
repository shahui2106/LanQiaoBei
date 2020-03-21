package ZhenTi.HistroyOf2017;

import java.util.Scanner;

/**
 * 标题：包子凑数
 * <p>
 * 小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。
 * 每种蒸笼都有非常多笼，可以认为是无限笼。
 * 每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。
 * 比如一共有3种蒸笼，分别能放3、4和5个包子。当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。
 * 当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。
 * 而顾客想买7个包子时，大叔就凑不出来了。
 * 小明想知道一共有多少种数目是包子大叔凑不出来的。
 * <p>
 * 输入
 * ----
 * 第一行包含一个整数N。(1 <= N <= 100)
 * 以下N行每行包含一个整数Ai。(1 <= Ai <= 100)
 * <p>
 * 输出
 * ----
 * 一个整数代表答案。如果凑不出的数目有无限多个，输出INF。
 * <p>
 * 例如，
 * 输入：
 * 2
 * 4
 * 5
 * <p>
 * 程序应该输出：
 * 6
 * <p>
 * 再例如，
 * 输入：
 * 2
 * 4
 * 6
 * <p>
 * 程序应该输出：
 * INF
 *
 * @author Zhu
 * @createtime 2020/3/7-18:22
 */
public class 包子凑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] data = new int[N + 1];
        boolean[] tables = new boolean[100 * 100];
        int g = 0;
        int Num = 0;
        tables[0] = true;
        for (int i = 1; i < data.length; i++) {
            data[i] = sc.nextInt();
            if (i == 1) {
                g = data[1];
            } else
                g = gcd(data[i], g);

            for (int i1 = 0; i1 + data[i] < tables.length; i1++) {
                if (tables[i1])
                    tables[i1 + data[i]] = true;
            }
        }

        //所有数是互质的
        if (g == 1) {
            for (boolean table : tables) {
                if (!table)
                    Num++;
            }
            System.out.println(Num);
        } else
            System.out.println("INF");
    }

    /**
     * 求两个数的最大公约数
     *
     * @param a 数1
     * @param b 数2
     * @return 两个数的公约数
     */
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
