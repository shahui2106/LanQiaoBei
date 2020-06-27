package Nuist_OJ.P1044奇偶数排序;

import java.util.*;

/**
 * OJ系统练习题 -- 奇偶数排序
 *
 * @author Zhu
 * @createtime 2020/6/27-16:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> odd = new ArrayList<Integer>();
            List<Integer> even = new ArrayList<Integer>();
            int num = 0;
            while (num < 10) {
                int data = sc.nextInt();
                if ((data & 1) == 1) {
                    odd.add(data);
                } else {
                    even.add(data);
                }
                num++;
            }
            Collections.sort(odd);
            Collections.sort(even);
            for (int i = odd.size() - 1; i >= 0; i--) {
                System.out.print(odd.get(i) + " ");
            }
            for (Integer evenData : even) {
                System.out.print(evenData + " ");
            }
        }
    }
}
