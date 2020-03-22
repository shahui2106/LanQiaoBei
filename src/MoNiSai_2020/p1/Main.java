package MoNiSai_2020.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 填空题1 -- 1200000有多少个约数（只计算正约数）
 *
 * @author Zhu
 * @createtime 2020/3/22-9:01
 */
public class Main {
    static List<Integer> factors = new ArrayList<Integer>();

    public static void main(String[] args) {
        int n = 1200000;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                cnt++;
        }
        System.out.println(cnt);
    }
}
