package Nuist_OJ.P1092MatrixRotation;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * OJ系统练习题 -- Matrix Rotation
 *
 * @author Zhu
 * @createtime 2020/5/25-10:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[][] matrix = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextLong();
                }
            }
            int k = sc.nextInt();
            int num = k / 4;
            long[][] rote90 = rote90(matrix);
            long[][] rematain = rematain(matrix, k % 4);
            String res = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += ((rote90[i][j] * num) + rematain[i][j]) + " ";
                }
                res = res.trim();
                if (i != n - 1)
                    res += "\n";
            }
            System.out.println(res);
        }
    }

    public static long[][] rote90(long[][] matrix) {
        int n = matrix.length;
        long[][] tmp = new long[n][n];
        long[][] sum = new long[n][n];

        //求0-1Matrix之和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - i - 1] = matrix[i][j];
                sum[j][n - i - 1] = tmp[j][n - i - 1] + matrix[j][n - i - 1];
            }
        }

        //求0-2Matrix之和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = tmp[i][j];
                sum[j][n - i - 1] += matrix[j][n - i - 1];
            }
        }

        //求0-3Matrix之和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - i - 1] = matrix[i][j];
                sum[j][n - i - 1] += tmp[j][n - i - 1];
            }
        }

        //4Matrix == 0Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = tmp[i][j];
            }
        }
        return sum;
    }

    public static long[][] rematain(long[][] matrix, int yu) {
        int n = matrix.length;
        long[][] tmp = new long[n][n];
        long[][] sum = new long[n][n];
        switch (yu) {
            case 0:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sum[i][j] = matrix[i][j];
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tmp[j][n - i - 1] = matrix[i][j];
                        sum[j][n - i - 1] = tmp[j][n - i - 1] + matrix[j][n - i - 1];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tmp[j][n - i - 1] = matrix[i][j];
                        sum[j][n - i - 1] = tmp[j][n - i - 1] + matrix[j][n - i - 1];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][n - i - 1] = tmp[i][j];
                        sum[j][n - i - 1] += matrix[j][n - i - 1];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tmp[j][n - i - 1] = matrix[i][j];
                        sum[j][n - i - 1] = tmp[j][n - i - 1] + matrix[j][n - i - 1];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][n - i - 1] = tmp[i][j];
                        sum[j][n - i - 1] += matrix[j][n - i - 1];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tmp[j][n - i - 1] = matrix[i][j];
                        sum[j][n - i - 1] += tmp[j][n - i - 1];
                    }
                }
                break;
            default:
                break;
        }
        return sum;
    }

}
