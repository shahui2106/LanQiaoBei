package JiChuTi.GuiTuSaiPaoYuCe;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/14-13:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //兔子的速度
        int tu_v1 = sc.nextInt();
        //乌龟的速度
        int gui_v2 = sc.nextInt();
        //兔子比乌龟多跑了t米
        int t = sc.nextInt();
        //兔子等待t秒
        int s = sc.nextInt();
        //赛道总路程
        int sum_l = sc.nextInt();
        //经过的时间
        int second = 0;
        //乌龟已经跑了多少米
        int gui_l = 0;
        //兔子已经跑了多少米
        int tu_l = 0;
        //等待的时间
        int wait_s = 0;
        //兔子是否在等待
        boolean iswait = false;
        while (true) {
            //只要有一方胜利就结束比赛
            if (gui_l == sum_l || tu_l == sum_l)
                break;
            //判断兔子有没有追上乌龟
            if ((tu_l - gui_l) >= t) {
                //只有当兔子不在等待的状态下，兔子比乌龟多了t米之后才停下等待
                if (!iswait) {
                    iswait = true;
                    wait_s = s;
                }
            } else {
                //兔子不在等待状态才可以前进
                if (!iswait)
                    tu_l += tu_v1;
            }
            //如果兔子在等待中，将等待时间减一秒
            if (iswait) {
                wait_s--;
                if (wait_s == 0) {
                    iswait = false;
                }
            }

            //乌龟一直在前进
            gui_l += gui_v2;
            second++;
        }
        //如果结束后乌龟和兔子走过的路程一致，表示平手
        if (gui_l == tu_l) {
            System.out.println("D");
            //如果乌龟走过的路程和总路程一致，表示乌龟胜利
        } else if (gui_l == sum_l) {
            System.out.println("T");
            //如果兔子走过的路程和总路程一致，表示兔子胜利
        } else if (tu_l == sum_l) {
            System.out.println("R");
        }
        //所经历的时间
        System.out.println(second);
    }
}
