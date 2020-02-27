package JiChuTi.JuXingMianJiJiao;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/15-13:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //矩形1的两个对角坐标
        double[] ju1 = new double[4];
        //矩形2的两个对角坐标
        double[] ju2 = new double[4];
        //两个矩形相交所组成矩形的两个对角坐标
        double[] ju3 = new double[4];
        //初始化矩形1的数据
        for (int i = 0; i < ju1.length; i++) {
            ju1[i] = sc.nextDouble();
        }
        //初始化矩形2的数据
        for (int i = 0; i < ju2.length; i++) {
            ju2[i] = sc.nextDouble();
        }

        //规范为左下和右上两个坐标值
        change(ju1);
        change(ju2);
        //通过比较得到相交矩形的对角坐标值
        ju3[0] = Math.max(ju1[0], ju2[0]);
        ju3[1] = Math.max(ju1[1], ju2[1]);
        ju3[2] = Math.min(ju1[2], ju2[2]);
        ju3[3] = Math.min(ju1[3], ju2[3]);

        if (ju3[0] >= ju3[2] || ju3[1] >= ju3[3]) {
            System.out.println("0.00");
        } else {
            double area = (ju3[2] - ju3[0]) * (ju3[3] - ju3[1]);
            System.out.println(String.format("%.2f",area));
        }

    }

    private static void change(double[] ju) {
        if ((ju[0] < ju[2] && ju[1] > ju[3]) || (ju[0] > ju[2] && ju[1] < ju[3])){
            double temp = ju[1];
            ju[1] = ju[3];
            ju[3] = temp;
        }
        if(ju[0] >= ju[2] && ju[1] >= ju[3]){
            double temp = ju[1];
            ju[1] = ju[3];
            ju[3] = temp;
            temp = ju[0];
            ju[0] = ju[2];
            ju[2] = temp;
        }
    }
}
