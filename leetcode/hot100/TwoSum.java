import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. 两数之和（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/two-sum/
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *   输入：nums = [2,7,11,15], target = 9
 *   输出：[0,1]
 *
 * 示例 2：
 *   输入：nums = [3,2,4], target = 6
 *   输出：[1,2]
 *
 * 示例 3：
 *   输入：nums = [3,3], target = 6
 *   输出：[0,1]
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        Object[][] cases = {
            {new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}},
            {new int[]{3, 2, 4}, 6, new int[]{1, 2}},
            {new int[]{3, 3}, 6, new int[]{0, 1}},
        };

        for (Object[] c : cases) {
            int[] nums = (int[]) c[0];
            int target = (int) c[1];
            int[] expected = (int[]) c[2];
            int[] result = s.twoSum(nums, target);

            int[] sortedResult = result == null ? null : Arrays.copyOf(result, result.length);
            int[] sortedExpected = Arrays.copyOf(expected, expected.length);
            if (sortedResult != null) {
                Arrays.sort(sortedResult);
            }
            Arrays.sort(sortedExpected);

            boolean ok = Arrays.equals(sortedResult, sortedExpected);
            System.out.printf("[%s] nums=%s, target=%d -> %s (期望 %s)%n",
                    ok ? "PASS" : "FAIL",
                    Arrays.toString(nums),
                    target,
                    Arrays.toString(result),
                    Arrays.toString(expected));
        }
    }
}
