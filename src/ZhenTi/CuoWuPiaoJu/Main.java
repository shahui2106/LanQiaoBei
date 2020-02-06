package ZhenTi.CuoWuPiaoJu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-01-22 14:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //几行数据
        int n = sc.nextInt();
        //存放所有票据的
        List<Integer> pj = new ArrayList<>();
        //记录每行输入的数据
        String[] data = new String[n + 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextLine();
        }

        //取出所有的票据信息放入pj集合中
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(" ");
            for (int i1 = 0; i1 < split.length; i1++) {
                pj.add(Integer.parseInt(split[i1]));
            }
        }

        //获取所有票据中的最大值和最小值
        int max = pj.get(0), min = pj.get(0);
        for (Integer tmp : pj) {
            if (tmp > max)
                max = tmp;
            if (min > tmp)
                min = tmp;
        }

        //记录断号的和重号的
        int[] jilu = new int[max - min + 1];
        for (Integer tmp : pj) {
            jilu[tmp - min]++;
        }

        //取出断号的和重号的票据号码
        int duan = 0, chong = 0;
        for (int i = 0; i < jilu.length; i++) {
            if (jilu[i] == 0)
                duan = i + min;
            if (jilu[i] == 2)
                chong = i + min;
        }
        System.out.println(duan + " " + chong);
    }
}
