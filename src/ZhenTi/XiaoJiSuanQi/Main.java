package ZhenTi.XiaoJiSuanQi;

import java.util.Scanner;

/**
 * 历史真题 -- 小计算器
 *
 * @author zhu
 * @datetime 2020-02-08 9:03
 */
public class Main {
    //开始默认进制为十进制
    public static int jinzhi = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //指令数目
        int n = sc.nextInt();
        //存放运算数,第一位放结果或第一个输入的数
        Num[] nums = new Num[2];
        //运算指针
        int p = 0;
        //运算符号
        String fh = "";
        //指令数据初始化
        String[] instructions = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            instructions[i] = sc.nextLine();
        }

        //依次取指令
        for (String instruction : instructions) {
            String[] strings = instruction.split(" ");
            //通过判断指令长度来断定此指令有无参数
            int length = strings.length;
            //此指令无参数
            if (length == 1) {
                //输出指令，将十进制转化为当前进制输出数组nums的第一位，并将指令置一便于接收下一位数字
                if (strings[0].equals("EQUAL")) {
                    System.out.println(Long.toString(nums[0].getNum(), jinzhi).toUpperCase());
                    p = 1;
                    //重置指令，将指针置零，重新开始计算
                } else if (strings[0].equals("CLEAR")) {
                    p = 0;
                    //运算指令，先暂时存储
                } else {
                    fh = strings[0];
                }
                //此指令有参数
            } else if (length == 2) {
                //输入指令，以当前的进制转化为十进制并存入数组中
                if (strings[0].equals("NUM")) {
                    nums[p] = new Num(strings[1], jinzhi);
                    if (p == 1)
                        handle(nums, fh);
                    else
                        p++;
                    p = p % 2;
                    //改变进制指令，重置当前进制
                } else if (strings[0].equals("CHANGE")) {
                    jinzhi = Integer.parseInt(strings[1]);
                }
            }
        }
    }

    /**
     * 处理运算符号，并得出运算结果
     *
     * @param nums 运算数组
     * @param fh   运算符
     */
    private static void handle(Num[] nums, String fh) {
        long num1 = nums[0].getNum();
        long num2 = nums[1].getNum();
        long result = 0;
        if (fh.equals("ADD")) {
            result = num1 + num2;
        } else if (fh.equals("SUB")) {
            result = num1 - num2;
        } else if (fh.equals("MUL")) {
            result = num1 * num2;
        } else if (fh.equals("DIV")) {
            result = num1 / num2;
        } else if (fh.equals("MOD")) {
            result = num1 % num2;
        }
        nums[0].setNum(result);
    }
}

class Num {
    private long num;

    Num(String num, int jinzhi) {
        //将当前为几进制的数转化为十进制
        this.num = Long.parseLong(num, jinzhi);
    }

    public void setNum(long num) {
        this.num = num;
    }

    public long getNum() {
        return num;
    }
}
