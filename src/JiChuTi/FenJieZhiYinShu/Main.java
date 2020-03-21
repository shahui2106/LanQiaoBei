package JiChuTi.FenJieZhiYinShu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/18-14:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //区间左端点
        int a = sc.nextInt();
        //区间右端点
        int b = sc.nextInt();

        //依次得出区间内的质因数分解。
        for (int i = a; i <= b; i++) {
            getFactor(i);
        }
    }

    /**
     * 获取一个数的质因数分解表达式
     *
     * @param i 要质因数分解的数
     */
    private static void getFactor(int i) {
        //构造结果表达式
        String result = "" + i + "=";
        //此数质因数的集合
        List<Integer> factors = new LinkedList<Integer>();
        //从2开始依次判断
        for (int j = 2; j <= i; j++) {
            if (i % j == 0) {
                factors.add(j);
                i = i / j;
                j = 1;
            }
        }
        //构造表达式
        for (Integer factor : factors) {
            result += factor + "*";
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}
