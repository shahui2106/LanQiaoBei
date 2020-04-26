package SuanFaXunLian.YuCeShenGao;

import java.util.Scanner;

/**
 * 算法训练 -- 预测身高
 *
 * @author Zhu
 * @createtime 2020/4/17-20:49
 */
public class Main {
    public static void main(String[] args) {
        float res = 0;
        Scanner sc = new Scanner(System.in);
        int sex = sc.nextInt();
        float father = sc.nextFloat();
        float mother = sc.nextFloat();
        //1表示男性
        if (sex == 1) {
            //男孩成人后身高=（父亲身高+母亲身高）/2*1.08
            res = (float) ((father + mother) / 2 * 1.08);
        }
        //0表示女性
        else if (sex == 0) {
            //女孩成人后身高=(父亲身高*0.923+母亲身高）/2
            res = (float) ((father * 0.923 + mother) / 2);
        }
        System.out.println(String.format("%.3f", res));
    }
}
