package MoNiSai_2020.ShengNei.P2;

import java.util.HashSet;
import java.util.Set;

/**
 * 填空题2：
 * 　　将LANQIAO中的字母重新排列，可以得到不同的单词，如LANQIAO、AAILNOQ等，注意这7个字母都要被用上，单词不一定有具体的英文意义。
 * 　　请问，总共能排列如多少个不同的单词。
 *
 * @author Zhu
 * @createtime 2020/4/18-9:06
 */
public class Main {
    static Set<String> resSet = new HashSet<String>();

    public static void main(String[] args) {
        int[] data = new int[7];
        char[] chars = "LANQIAO".toCharArray();
        for (int i = 0; i < data.length; i++) {
            data[i] = chars[i];
        }
        perm(data, new int[7], new boolean[7], 0, data.length - 1);
        System.out.println(resSet.size());
    }

    /**
     * 全排列2：可以去除重复的排列
     *
     * @param arr   需要全排列的数组
     * @param path  容器，存放结构的容器
     * @param vis   标记当前元素是否抓取过
     * @param start 开始索引
     * @param end   结束索引
     */
    public static void perm(int[] arr, int[] path, boolean[] vis, int start, int end) {
        if (start == end + 1) {
            //内部逻辑，根据具体的情况去处理不同check
            String res = "";
            for (int i : path) {
                res += (char) i;
            }
            resSet.add(res);
        }
        for (int i = 0; i <= end; i++) {
            //当前元素和上一个元素相同，但是上一个元素还没有抓取，就不允许抓取当前元素
            if (i > 0 && arr[i] == arr[i - 1] && !vis[i - 1])
                continue;
            if (!vis[i]) {
                vis[i] = true;
                path[start] = arr[i];
                perm(arr, path, vis, start + 1, end);
                vis[i] = false;
            }
        }
    }
}
