package JiChuTi.QuHuiXingShu;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/13-16:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] data = new int[m][n];
        String result = "";
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data[i].length; i1++) {
                data[i][i1] = sc.nextInt();
            }
        }

        int up_left = 0;
        int down_left = data.length - 2;
        int left_down = 0;
        int right_down = data[0].length - 2;
        int down_right = data.length - 1;
        int up_right = 1;
        int right_up = data[0].length - 1;
        int left_up = 1;


        int count = 0;
        while (true) {
            if (up_left > down_left && left_down > right_down && down_right < up_right && right_up < left_up)
                break;
            if (up_left <= down_left) {
                result += upToDown(data, up_left, down_left, count);
                up_left++;
                down_left--;
            }

            if (left_down <= right_down) {
                result += leftToRight(data, left_down, right_down, count);
                left_down++;
                right_down--;
            }

            if (down_right >= up_right) {
                result += downToUp(data, down_right, up_right, count);
                down_right--;
                up_right++;
            }

            if (right_up >= left_up) {
                result += rightToLeft(data, right_up, left_up, count);
                right_up--;
                left_up++;
            }
            count++;
        }
        System.out.println(result);

    }

    //上面从右往左遍历
    private static String rightToLeft(int[][] data, int right_up, int left_up, int count) {
        String result = "";
        for (int i = right_up; i >= left_up; i--) {
            result += data[count][i] + " ";
        }
        return result;
    }

    //右面从下往上遍历
    private static String downToUp(int[][] data, int down_right, int up_right, int count) {
        String result = "";
        for (int i = down_right; i >= up_right; i--) {
            result += data[i][data[0].length - count - 1] + " ";
        }
        return result;
    }

    //下面从左往右遍历
    private static String leftToRight(int[][] data, int left_down, int right_down, int count) {
        String result = "";
        for (int i = left_down; i <= right_down; i++) {
            result += data[data.length - count - 1][i] + " ";
        }
        return result;
    }


    //左边从上到下遍历
    private static String upToDown(int[][] data, int up_left, int down_left, int count) {
        String result = "";
        for (int i = up_left; i <= down_left; i++) {
            result += data[i][count] + " ";
        }
        return result;
    }
}
