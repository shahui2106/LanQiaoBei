package JiChuTi.WanMeiDeDaiJia;

import java.util.Scanner;

/**
 * @author Zhu
 * @createtime 2020/1/16-9:47
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //字符串的长度
        int n = sc.nextInt();
        //字符串
        String data = sc.next();
        //需要交换的总次数
        int sum = 0;
        while (data.length() > 1) {
            //每次寻找与左右最近相同的那个字符，并计算出需要交换几次
            int outChangeNum = getOutChangeNum(data, 0);
            //如果交换次数为-1，表示这个字符串不可能为回文串
            if (outChangeNum == -1) {
                sum = -1;
                break;
            }
            //将最外层两个一样字符去掉，再次寻找
            data = getChangeData(data, outChangeNum);
            //计算得到总的交换次数
            sum += outChangeNum;
        }
        if (sum != -1)
            System.out.println(sum);
        else
            System.out.println("Impossible");
    }

    /**
     * 将左右两个相同字符删除，取出中间的字符串
     * @param data 原字符串
     * @param index 和左或者右字符相同的字符索引
     * @return 删除左右字符后，中间的字符串
     */
    private static String getChangeData(String data, int index) {
        StringBuffer tmp = new StringBuffer(data);
        //如果左边字符和index下字符相同
        if (data.charAt(0) == data.charAt(data.length() - index - 1)) {
            tmp.delete(0, 1);
            tmp.delete(data.length() - index - 2, data.length() - index - 1);
            //如果右边字符和index下字符相同
        } else if (data.charAt(data.length() - 1) == data.charAt(index)) {
            tmp.delete(data.length() - 1, data.length());
            tmp.delete(index, index + 1);
        }
        return tmp.toString();
    }

    /**
     * 获取与左或右字符相同字符所需要交换的次数
     * @param data 原字符串
     * @param index 第index个字符
     * @return 不需要交换返回 0
     *         不能交换返回 -1
     *         能交换放回具体交换次数 num
     */
    private static int getOutChangeNum(String data, int index) {
        int length = data.length();
        int tail = length - index - 1;
        int num1 = 0;
        int num2 = 0;
        boolean isNum1has = false;
        boolean isNum2has = false;
        if (tail == index)
            return 0;
        if (data.charAt(index) != data.charAt(tail)) {
            //从头找与尾部相同的字符
            for (int i = index + 1; i < tail; i++) {
                if (data.charAt(i) == data.charAt(tail)) {
                    isNum1has = true;
                    num1++;
                    break;
                } else
                    num1++;
            }
            //从尾找与头部相同的字符
            for (int i = tail - 1; i > index; i--) {
                if (data.charAt(i) == data.charAt(index)) {
                    isNum2has = true;
                    num2++;
                    break;
                } else
                    num2++;
            }
            if (isNum1has && isNum2has) {
                return Math.min(num1, num2);
            } else if (isNum1has) {
                return num1;
            } else if (isNum2has) {
                return num2;
            } else
                return -1;
        } else return 0;
    }
}
