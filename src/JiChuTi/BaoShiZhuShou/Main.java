package JiChuTi.BaoShiZhuShou;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/13-15:42
 */
public class Main {
    private static String[] table = {"zero", " one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        String result = "";
        if (h > 20) {
            result += "twenty";
            result += " " + table[h % 10];
        } else {
            result = table[h];
        }

        if (m == 0) {
            result += " o'clock";
        } else {
            if (m > 20) {
                int temp = m % 10;
                switch (m / 10) {
                    case 2:
                        result += " twenty " + table[temp];
                        break;
                    case 3:
                        result += " thirty " + table[temp];
                        break;
                    case 4:
                        result += " forty " + table[temp];
                        break;
                    case 5:
                        result += " fifty " + table[temp];
                        break;
                    default:
                        break;
                }
            } else {
                result += " " + table[m];
            }
        }
        System.out.println(result);
    }
}
