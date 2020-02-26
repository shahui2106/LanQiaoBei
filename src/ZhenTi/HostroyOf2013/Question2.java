package ZhenTi.HostroyOf2013;

/**
 * 2013年省赛真题2：
 * 假设  a,b,c,d,e 是 1~9不相同的5个数
 * 满足 ab * cde = adb * ce的式子有多少种？
 *
 * @author zhu
 * @datetime 2020-02-25 16:28
 */
public class Question2 {
    public static void main(String[] args) {
        int count = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (b != a)
                    for (int c = 1; c <= 9; c++) {
                        if (c != a && c != b)
                            for (int d = 1; d <= 9; d++) {
                                if (d != a && d != b && d != c)
                                    for (int e = 1; e <= 9; e++) {
                                        if (e != a && e != b && e != c && e != d) {
                                            if ((10 * a + b) * (c * 100 + d * 10 + e) == (10 * c + e) * (a * 100 + d * 10 + b))
                                                count++;
                                        }
                                    }
                            }
                    }
            }

        }
        System.out.println(count);
    }
}
