package Nuist_OJ.P1135NBA总冠军;

import javax.naming.Name;
import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ系统练习题 -- NBA总冠军
 *
 * @author Zhu
 * @createtime 2020/7/6-14:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Champion[] data = new Champion[n];
            sc.nextLine();
            for (int i = 0; i < data.length; i++) {
                String tmp = sc.nextLine();
                int index = tmp.lastIndexOf(" ");
                data[i] = new Champion(tmp.substring(0, index), Integer.parseInt(tmp.substring(index + 1)));
            }
            Arrays.sort(data);
            for (int i = 0; i < data.length; i++) {
                if (i - 1 > 0 && data[i].year == data[i - 1].year)
                    continue;
                System.out.println((data[i].year + " " + data[i].name));
            }
        }
    }

    static class Champion implements Comparable<Champion> {
        String name;
        int year;

        Champion(String name, int year) {
            this.year = year;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Champion{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    '}';
        }

        @Override
        public int compareTo(Champion o) {
            return o.year > this.year ? -1 : 1;
        }
    }

}
