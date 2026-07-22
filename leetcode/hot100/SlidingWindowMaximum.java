import java.util.Arrays;

/**
 * LeetCode 239. 滑动窗口最大值（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/sliding-window-maximum/
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值。
 *
 * 示例 1：
 *   输入: nums = [1,3,-1,-3,5,3,6,7], k = 3
 *   输出: [3,3,5,5,6,7]
 *   解释:
 *     滑动窗口的位置                最大值
 *     ---------------               -----
 *     [1  3  -1] -3  5  3  6  7       3
 *      1 [3  -1  -3] 5  3  6  7       3
 *      1  3 [-1  -3  5] 3  6  7       5
 *      1  3  -1 [-3  5  3] 6  7       5
 *      1  3  -1  -3 [5  3  6] 7       6
 *      1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 *   输入: nums = [1], k = 1
 *   输出: [1]
 *
 * 提示：
 *   1 <= nums.length <= 10^5
 *   -10^4 <= nums[i] <= 10^4
 *   1 <= k <= nums.length
 */
class SlidingWindowMaximumSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 在这里写你的解法
        return new int[0];
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximumSolution s = new SlidingWindowMaximumSolution();

        check(s, new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}, "case1");
        check(s, new int[]{1}, 1, new int[]{1}, "case2");
        check(s, new int[]{9, 11}, 2, new int[]{11}, "case3");
    }

    private static void check(SlidingWindowMaximumSolution s, int[] nums, int k, int[] expected, String name) {
        int[] result = s.maxSlidingWindow(nums, k);
        boolean ok = Arrays.equals(result, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.toString(result),
                Arrays.toString(expected));
    }
}
