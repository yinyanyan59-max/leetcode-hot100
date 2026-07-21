/**
 * LeetCode 11. 盛最多水的容器（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/container-with-most-water/
 *
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 *   输入: height = [1,8,6,2,5,4,8,3,7]
 *   输出: 49
 *   解释: 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 *         在此情况下，容器可以容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 *   输入: height = [1,1]
 *   输出: 1
 *
 * 提示：
 *   n == height.length
 *   2 <= n <= 10^5
 *   0 <= height[i] <= 10^4
 */
class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        // 在这里写你的解法
        return 0;
    }
}

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWaterSolution s = new ContainerWithMostWaterSolution();

        check(s, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49, "case1");
        check(s, new int[]{1, 1}, 1, "case2");
        check(s, new int[]{4, 3, 2, 1, 4}, 16, "case3");
    }

    private static void check(ContainerWithMostWaterSolution s, int[] height, int expected, String name) {
        int result = s.maxArea(height);
        boolean ok = result == expected;
        System.out.printf("[%s] %s -> %d (期望 %d)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }
}
