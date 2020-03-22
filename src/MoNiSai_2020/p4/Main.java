package MoNiSai_2020.p4;

/**
 * 填空题4 -- 在1至2019中，有多少个数的数位中包含数字9？
 *
 * @author Zhu
 * @createtime 2020/3/22-9:20
 */
public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i <= 2019; i++) {
            if (String.valueOf(i).contains("9")) {
                cnt++;
                System.out.println("i = " + i);
            }
        }
        System.out.println(cnt);
    }
}
