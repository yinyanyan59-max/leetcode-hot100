import java.util.Arrays;

/**
 * LeetCode 128. 最长连续序列（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/longest-consecutive-sequence/
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 *   输入：nums = [100,4,200,1,3,2]
 *   输出：4
 *   解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 *   输入：nums = [0,3,7,2,5,8,4,6,0,1]
 *   输出：9
 *
 * 提示：
 *   0 <= nums.length <= 10^5
 *   -10^9 <= nums[i] <= 10^9
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // 在这里写你的解法
        return 0;
    }
}

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution s = new Solution();
        Object[][] cases = {
            {new int[]{100, 4, 200, 1, 3, 2}, 4},
            {new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9},
            {new int[]{}, 0},
            {new int[]{1}, 1},
        };

        for (Object[] c : cases) {
            int[] nums = (int[]) c[0];
            int expected = (int) c[1];
            int result = s.longestConsecutive(nums);
            boolean ok = result == expected;
            System.out.printf("[%s] nums=%s -> %d (期望 %d)%n",
                    ok ? "PASS" : "FAIL",
                    Arrays.toString(nums),
                    result,
                    expected);
        }
    }
}
