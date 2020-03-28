package MoNiSai_2020.p9;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/3/28-16:34
 */
public class Test {
    static int maxLength = 1;
    static int tmp = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        f(data, 0, 1);
        System.out.println(maxLength);
    }

    private static void f(int[] data, int pre, int cur) {

        if (data[pre] < data[cur])
            tmp++;
        else {
            maxLength = Math.max(maxLength, tmp);
            tmp = 1;
        }

        if (cur == data.length - 1) {
            return;
        }
        f(data, cur, cur + 1);
    }
}
