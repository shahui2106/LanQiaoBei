package Nuist_OJ.P1075不高兴的津津;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ系统练习题 -- 不高兴的津津
 *
 * @author Zhu
 * @createtime 2020/6/27-19:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Day[] data = new Day[7];
            for (int i = 0; i < data.length; i++) {
                data[i] = new Day((i + 1), (sc.nextInt() + sc.nextInt()));
            }
            Arrays.sort(data);
            System.out.println((data[0].time <= 8 ? 0 : data[0].index));
        }
    }

    static class Day implements Comparable<Day> {
        int index;
        int time;

        @Override
        public String toString() {
            return "Day{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }

        Day(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Day o) {
            return this.time > o.time ? -1 : 1;
        }
    }
}
