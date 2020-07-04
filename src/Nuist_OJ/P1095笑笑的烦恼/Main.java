package Nuist_OJ.P1095笑笑的烦恼;

import java.util.Scanner;

/**
 * OJ系统练习题 -- 笑笑的烦恼
 *
 * @author Zhu
 * @createtime 2020/7/4-20:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int tmp = sc.nextInt();
                int count = 0;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int sum = 0;
                while (tmp != -1) {
                    count++;
                    max = Math.max(max, tmp);
                    min = Math.min(min, tmp);
                    sum += tmp;
                    tmp = sc.nextInt();
                }
                System.out.println(count);
                System.out.println(max);
                System.out.println(min);
                System.out.println(String.format("%.1f", sum * 1.0 / count));
            }
        }
    }
}
