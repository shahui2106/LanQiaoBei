package SuanFaTiGao.TeDengJiangXueJin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法提高 -- 特等奖学金
 *
 * @author zhu
 * @datetime 2020-02-07 11:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //学生名数
        int n = sc.nextInt();
        //科目数
        int m = sc.nextInt();
        //奖学金个数
        int k = sc.nextInt();

        Student[] students = new Student[n];

        //初始化学生数据
        for (int i = 0; i < n; i++) {
            int[] grade = new int[m];
            for (int j = 0; j < m; j++) {
                grade[j] = sc.nextInt();
            }
            students[i] = new Student(grade);
            students[i].setXuehao(i + 1);
        }

        //进行排序
        Arrays.sort(students);

        int count = 0;
        for (Student student : students) {
            boolean isgood = true;
            for (int i = 0; i < m; i++) {
                if (student.grade[i] < 85) {
                    isgood = false;
                    break;
                }
            }
            if (isgood) {
                count++;
                System.out.print(student.xuehao + " ");
                if (count == k)
                    break;
            }
        }

    }
}

/**
 * 学生类 实现了Comparable进行grade降序排列
 * 属性：xuehao -- 学号
 * grade -- 成绩数组
 */
class Student implements Comparable<Student> {
    int xuehao;
    int[] grade;

    Student(int[] grade) {
        this.grade = grade;
    }

    public void setXuehao(int xuehao) {
        this.xuehao = xuehao;
    }

    @Override
    public int compareTo(Student o) {
        int length = this.grade.length;
        for (int i = 0; i < length; i++) {
            int comparevalue = 0;
            if (this.grade[i] > o.grade[i]) {
                comparevalue = 1;
            } else if (this.grade[i] < o.grade[i]) {
                comparevalue = -1;
            }
            if (comparevalue != 0) {
                return -comparevalue;
            }
        }
        return 0;
    }
}