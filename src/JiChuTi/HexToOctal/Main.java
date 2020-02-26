package JiChuTi.HexToOctal;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/11-14:14
 */
public class Main {
    public static String[] Hex_data = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    public static String[] oct_data = {"0", "1", "2", "3", "4", "5", "6", "7"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] data = new String[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.next();
        }

        for (int i = 0; i < data.length; i++) {
            //十六进制  →  二进制
            String Bin = HexToBin(data[i]);

            //二进制  → 八进制
            String answer = BinToOct(Bin);

            if (answer.startsWith("0"))
                answer = answer.substring(1);
            System.out.println(answer);
        }
    }

    //方法一：十六进制转换成而二进制
    private static String HexToBin(String datum) {
        StringBuffer bin = new StringBuffer();
        for (int i = 0; i < datum.length(); i++) {
            bin.append(tranform(datum.substring(i, i + 1)));
        }
        return bin.toString();
    }

    //将抽取的其中某个字符由十六进制字符转换成二进制字符
    private static String tranform(String str) {
        String result = "";
       /*   switch (str) {
            case "0":
                result = Hex_data[0];
                break;
            case "1":
                result = Hex_data[1];
                break;
            case "2":
                result = Hex_data[2];
                break;
            case "3":
                result = Hex_data[3];
                break;
            case "4":
                result = Hex_data[4];
                break;
            case "5":
                result = Hex_data[5];
                break;
            case "6":
                result = Hex_data[6];
                break;
            case "7":
                result = Hex_data[7];
                break;
            case "8":
                result = Hex_data[8];
                break;
            case "9":
                result = Hex_data[9];
                break;
            case "A":
                result = Hex_data[10];
                break;
            case "B":
                result = Hex_data[11];
                break;
            case "C":
                result = Hex_data[12];
                break;
            case "D":
                result = Hex_data[13];
                break;
            case "E":
                result = Hex_data[14];
                break;
            case "F":
                result = Hex_data[15];
                break;
            default:
                break;
        }*/
        return result;
    }

    //将抽取的二进制字符串转换成八进制字符
    private static String BinToOct(String Bin) {
        StringBuffer result = new StringBuffer();
        int length = Bin.length();
        if (length % 3 == 1) {
            Bin = "00" + Bin;
        } else if (length % 3 == 2) {
            Bin = "0" + Bin;
        }
        for (int k = 0; k < length; k += 3) {
            String temp = Bin.substring(k, k + 3);
            result.append(tranform2(temp));
        }
        return result.toString();
//        return (temp.charAt(0) - 48 )* 4 + (temp.charAt(1) - 48 )* 2 + (temp.charAt(2) - 48 );
    }

    //将抽取其中三个字符由二进制字符串转换成八进制字符
    private static String tranform2(String str) {
        String result = "";
        /*switch (str) {
            case "000":
                result = oct_data[0];
                break;
            case "001":
                result = oct_data[1];
                break;
            case "010":
                result = oct_data[2];
                break;
            case "011":
                result = oct_data[3];
                break;
            case "100":
                result = oct_data[4];
                break;
            case "101":
                result = oct_data[5];
                break;
            case "110":
                result = oct_data[6];
                break;
            case "111":
                result = oct_data[7];
                break;
        }*/
        return result;
    }
}
