package SuanFaTiGao.YinShiFenJie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 算法提高 -- 因式分解
 *
 * @author Zhu
 * @createtime 2020/3/21-22:00
 */
public class Main {
    static List<Integer> factors = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        String res = "";
        getFactor(n);
        for (Integer factor : factors) {
            res += factor + "*";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

    /**
     * 获取n的其中一个因子
     *
     * @param n 数值
     */
    private static void getFactor(int n) {
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) {
                factors.add(n / i);
                //将结果在去取下一个因子
                getFactor(i);
                return;
            }
        }
        factors.add(n);
    }
}
