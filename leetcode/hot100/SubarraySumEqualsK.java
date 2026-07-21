import java.util.Arrays;

/**
 * LeetCode 560. 和为 K 的子数组（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/subarray-sum-equals-k/
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 *   输入：nums = [1,1,1], k = 2
 *   输出：2
 *
 * 示例 2：
 *   输入：nums = [1,2,3], k = 3
 *   输出：2
 *
 * 提示：
 *   1 <= nums.length <= 2 * 10^4
 *   -1000 <= nums[i] <= 1000
 *   -10^7 <= k <= 10^7
 */
class SubarraySumEqualsKSolution {
    public int subarraySum(int[] nums, int k) {
        // 在这里写你的解法
        return 0;
    }
}

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsKSolution s = new SubarraySumEqualsKSolution();

        check(s, new int[]{1, 1, 1}, 2, 2, "case1");
        check(s, new int[]{1, 2, 3}, 3, 2, "case2");
        check(s, new int[]{1, -1, 0}, 0, 3, "case3");
    }

    private static void check(SubarraySumEqualsKSolution s, int[] nums, int k, int expected, String name) {
        int result = s.subarraySum(nums, k);
        boolean ok = result == expected;
        System.out.printf("[%s] %s nums=%s, k=%d -> %d (期望 %d)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.toString(nums),
                k,
                result,
                expected);
    }
}
