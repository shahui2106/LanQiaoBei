package SuanFaTiGao.WenBenJiaMi;

import java.util.Scanner;

/**
 * 算法提高 -- 文本加密
 *
 * @author Zhu
 * @createtime 2020/3/21-21:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        sc.close();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            res.append(EncryptChar(data.charAt(i)));
        }
        System.out.println(res);
    }

    /**
     * 字符加密
     *
     * @param charAt 要加密的字符
     * @return 加密后的字符
     */
    private static char EncryptChar(char charAt) {
        char res = '\0';
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt <= 'z' && charAt >= 'a')) {
            if (charAt == 'Z')
                return 'a';
            if (charAt == 'z')
                return 'A';
            return (char) (charAt + 1);
        }
        return charAt;
    }
}
