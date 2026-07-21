import java.util.Arrays;

/**
 * LeetCode 42. 接雨水（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/trapping-rain-water/
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *   输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *   输出: 6
 *   解释: 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图。
 *         在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 *   输入: height = [4,2,0,3,2,5]
 *   输出: 9
 *
 * 提示：
 *   n == height.length
 *   1 <= n <= 2 * 10^4
 *   0 <= height[i] <= 10^5
 */
class TrappingRainWaterSolution {
    public int trap(int[] height) {
        // 在这里写你的解法
        return 0;
    }
}

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWaterSolution s = new TrappingRainWaterSolution();

        check(s, new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6, "case1");
        check(s, new int[]{4, 2, 0, 3, 2, 5}, 9, "case2");
        check(s, new int[]{1, 2, 3}, 0, "case3");
    }

    private static void check(TrappingRainWaterSolution s, int[] height, int expected, String name) {
        int result = s.trap(height);
        boolean ok = result == expected;
        System.out.printf("[%s] %s -> %d (期望 %d)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }
}
