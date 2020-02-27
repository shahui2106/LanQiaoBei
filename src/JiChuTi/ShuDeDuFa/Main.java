package JiChuTi.ShuDeDuFa;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/14-15:01
 */
public class Main {
    static String[] table = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int length = data.length();
        String result = "";
        String temp = "";
        switch ((length - 1) / 4) {
            case 2://9-12
                temp = data.substring(0, length % 4);
                data = data.substring(length % 4);
                length = data.length();
                result += baseRead(temp) + "yi" + " ";
            case 1://5-8
                temp = data.substring(0, length - 4);
                data = data.substring(length - 4);
                result += baseRead(temp) + "wan" + " ";
            case 0://1-4
                result += baseRead(data);
                break;
            default:
                break;
        }
        System.out.println(result);
    }

    /**
     * 四位最基础的数字读法
     *
     * @param data 一个小于等于四位的数
     * @return 此数的读法
     */
    private static String baseRead(String data) {
        String result = "";
        if (data.startsWith("0") && data.length() == 4) {
            result = "ling" + " ";
        }
        while (data.startsWith("0")) {
            data = data.substring(1);
        }
        int length = data.length();
        switch (length) {
            case 4:
                result += table[(int) data.charAt(length - 4) - 48] + " " + "qian" + " ";
            case 3:
                int bai = (int) data.charAt(length - 3) - 48;
                if (bai > 0)
                    result += table[bai] + " " + "bai" + " ";
                else
                {
                    if((int) data.charAt(length - 1)-48 != 0 || (int) data.charAt(length - 2)-48 != 0)
                    result += "ling" + " ";
                }
            case 2:
                int shi = (int) data.charAt(length - 2) - 48;
                if (shi > 0) {
                    if (result.length() > 0 || length > 2)
                        result += table[shi] + " " + "shi" + " ";
                    else
                        result += "shi" + " ";
                } else {
                    if (length > 2 && (int) data.charAt(length - 3) - 48 != 0 && (int) data.charAt(length - 1)-48 != 0) {
                        result += "ling" + " ";
                    }

                }
            case 1:
                int ge = (int) data.charAt(length - 1) - 48;
                if (ge > 0)
                    result += table[(int) data.charAt(length - 1) - 48] + " ";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
}
