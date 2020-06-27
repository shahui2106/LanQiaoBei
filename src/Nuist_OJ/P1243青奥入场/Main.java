package Nuist_OJ.P1243青奥入场;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 青奥入场
 *
 * @author Zhu
 * @createtime 2020/5/24-20:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Nation[] data = new Nation[n];
            for (int i = 0; i < n; i++) {
                data[i] = new Nation(sc.next(), sc.next(), sc.next(), sc.next());
            }
            Arrays.sort(data);
            for (Nation datum : data) {
                System.out.println(datum);
            }
        }
    }

    static class Nation implements Comparable<Nation> {
        private String index;
        private String name;
        private String perNum;
        private String Continent;

        @Override
        public String toString() {
            return index + " " + name + " " + perNum + " " + Continent;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPerNum() {
            return perNum;
        }

        public void setPerNum(String perNum) {
            this.perNum = perNum;
        }

        public String getContinent() {
            return Continent;
        }

        public void setContinent(String continent) {
            Continent = continent;
        }

        public Nation(String index, String name, String perNum, String continent) {
            this.index = index;
            this.name = name;
            this.perNum = perNum;
            Continent = continent;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.getName().equals("China"))
                return 1;
            else
                return -o.getName().compareTo(this.getName());
        }
    }
}
