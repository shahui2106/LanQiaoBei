package ZhenTi.XiaoShuDiNWei;

import java.util.Scanner;

/**
 * 历史真题 -- 小数第n位
 *
 * @author zhu
 * @datetime 2020-02-10 19:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //被除数
        int a = sc.nextInt();
        //除数
        int b = sc.nextInt();
        //位数
        int n = sc.nextInt();

        /*方法一：利用BigDecimal类
         * BigDecimal div1 = new BigDecimal(a);
         * BigDecimal div2 = new BigDecimal(b);
         * BigDecimal decimal = div1.divide(div2,n+3,BigDecimal.ROUND_HALF_EVEN);
         * String result = decimal.toString();
         * int length = result.length();
         * System.out.println(result.substring(length-4,length-1));
         */


        //方法二：循环运算计算出前n+3个小数，在取出最后三个小数
        //最终结果
        StringBuilder res = new StringBuilder();
        //余数
        int remainder = a % b;
        n += 2;
        while (n > 0) {
            remainder *= 10;
            //保留最后三位小数
            if (n <= 3)
                res.append(remainder / b);
            //利用循环替代取余操作，提高效率
            while (remainder > b)
                remainder = remainder - b;
            n--;
        }
        System.out.println(res);
    }
}
