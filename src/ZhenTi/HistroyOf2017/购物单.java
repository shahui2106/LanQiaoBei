package ZhenTi.HistroyOf2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhu
 * @datetime 2020-02-26 10:19
 */
public class 购物单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> introduction = new ArrayList<String>();
        String price = "";
        float sum = 0;
        int i = 0;
        while (sc.hasNext()) {
            String tmp = sc.next();
            introduction.add(tmp);
            i++;
            if (i == 99)
                break;
        }
        for (String tmp : introduction) {
            if (tmp.endsWith("折")) {
                float zhekou = 0;
                String newtmp = tmp.substring(0, tmp.length() - 1);
                if (newtmp.contains("半")) {
                    zhekou = 0.5f;
                } else
                    zhekou = (float) (Float.parseFloat(newtmp) * 0.01);
                sum += (1 - zhekou) * Float.parseFloat(price);
            } else {
                price = tmp;
            }
        }
        System.out.println(sum);
    }
}
