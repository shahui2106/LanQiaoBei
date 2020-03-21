package SuanFaTiGao.ZiFuChuanShunXuBiJiao;

import java.util.Scanner;

/**
 * 算法提高 -- 字符串顺序比较
 *
 * @author Zhu
 * @createtime 2020/3/21-16:18
 */
public class Main {
    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        //计算s2和s1字符的差值
        int gap = s2.compareTo(s1);
        //差值为正表示s1优先于s2
        if (gap > 0)
            res = 1;
            //差值为负表示s1后于s2
        else if (gap < 0)
            res = -1;
        System.out.print(res);
    }
}
