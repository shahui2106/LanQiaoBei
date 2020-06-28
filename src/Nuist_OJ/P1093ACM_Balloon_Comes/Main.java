package Nuist_OJ.P1093ACM_Balloon_Comes;

import java.util.Scanner;

/**
 * OJ系统练习题 -- [ACM]Balloon Comes
 *
 * @author Zhu
 * @createtime 2020/6/28-16:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                String operate = sc.next();
                System.out.println(operate(operate, sc.nextInt(), sc.nextInt()));
            }
        }
    }

    private static String operate(String operate, int a, int b) {
        if (operate.equals("+")) {
            return "" + (a + b);
        }
        if (operate.equals("-")) {
            return "" + (a - b);
        }
        if (operate.equals("*")) {
            return "" + (a * b);
        }
        if (operate.equals("/")) {
            float sum = (float) (a * 1.0 / b);
            if (sum - ((int) sum) == 0)
                return "" + (int) sum;
            else
                return String.format("%.2f", sum);
        }
        return null;
    }
}
