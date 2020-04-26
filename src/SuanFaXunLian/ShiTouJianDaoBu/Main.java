package SuanFaXunLian.ShiTouJianDaoBu;

import java.util.Scanner;

/**
 * 算法训练 -- 生活大爆炸版石头剪刀布
 *
 * @author Zhu
 * @createtime 2020/4/26-19:07
 */
public class Main {
    static int[][] table = {//甲对乙的结果（列：甲A，行：乙B）
            {0, -1, 1, 1, -1},
            {1, 0, -1, 1, -1},
            {-1, 1, 0, -1, 1},
            {-1, -1, 1, 0, 1},
            {1, 1, -1, -1, 0}};

    public static void main(String[] args) {
        int A_Score = 0;
        int B_Score = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int NA = sc.nextInt();
        int NB = sc.nextInt();
        int[] A = new int[NA];
        int[] B = new int[NB];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int A_index = i % NA;
            int B_index = i % NB;
            if (table[A[A_index]][B[B_index]] > 0)
                A_Score++;
            else if (table[A[A_index]][B[B_index]] < 0)
                B_Score++;
        }
        System.out.println(A_Score + " " + B_Score);
    }
}
