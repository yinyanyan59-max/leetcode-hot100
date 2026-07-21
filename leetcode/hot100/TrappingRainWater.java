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
        int right_max = 0;
        int left_max = 0;
        int left_sum = 0;
        int right_sum = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left){
            if(height[left] < height[right]){
                if(height[left]>left_max){
                    left_max = height[left];
                }else {
                    left_sum += left_max - height[left];
                }
                left++;
            }else {
                if (height[right]>right_max){
                    right_max = height[right];
                }else {
                    right_sum += right_max - height[right];
                }
                right--;
            }
        }

        return left_sum + right_sum;
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
