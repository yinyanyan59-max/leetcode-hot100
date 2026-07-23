import java.util.ArrayList;
import java.util.Arrays;

/**
 * LeetCode 56. 合并区间（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/merge-intervals/
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *   输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *   输出：[[1,6],[8,10],[15,18]]
 *   解释：区间 [1,3] 和 [2,6] 重叠，将它们合并为 [1,6]。
 *
 * 示例 2：
 *   输入：intervals = [[1,4],[4,5]]
 *   输出：[[1,5]]
 *   解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 *   1 <= intervals.length <= 10^4
 *   intervals[i].length == 2
 *   0 <= starti <= endi <= 10^4
 */
class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        // 在这里写你的解法
        for(int i=0;i<intervals.length;i++){
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[i][0]>intervals[j][0]){
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
        ArrayList<int[]> results = new ArrayList<>();
        int n = 0;
        for(int i =0;i<intervals.length;i++){
            int j=i;
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            while(j+1<=intervals.length ){
                if(j+1<intervals.length&&temp[1]>=intervals[j+1][0]){
                    temp[1] = Math.max(temp[1], intervals[j+1][1]);
                }else {
                    break;
                }
                j++;
            }
            results.add(temp);
            n++;
            i = j;
        }
        int[][] arr = new int[results.size()][2];
        int i = 0;
        for(int[] result:results){
            arr[i] = result;
            i++;
        }
        return arr;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervalsSolution s = new MergeIntervalsSolution();

        check(s,
                new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                new int[][]{{1, 6}, {8, 10}, {15, 18}},
                "case1");
        check(s,
                new int[][]{{1, 10}, {2, 3},{4, 5}},
                new int[][]{{1, 10}},
                "case2");
        check(s,
                new int[][]{{1, 4}, {0, 4}},
                new int[][]{{0, 4}},
                "case3");
    }

    private static void check(MergeIntervalsSolution s, int[][] intervals, int[][] expected, String name) {
        int[][] result = s.merge(intervals);
        boolean ok = Arrays.deepEquals(result, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.deepToString(result),
                Arrays.deepToString(expected));
    }
}
