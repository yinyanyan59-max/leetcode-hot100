import java.util.Arrays;

/**
 * LeetCode 41. 缺失的第一个正数（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/first-missing-positive/
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 *   输入：nums = [1,2,0]
 *   输出：3
 *   解释：范围 [1,2] 中的数字都在数组中。
 *
 * 示例 2：
 *   输入：nums = [3,4,-1,1]
 *   输出：2
 *   解释：1 在数组中，但 2 没有。
 *
 * 示例 3：
 *   输入：nums = [7,8,9,11,12]
 *   输出：1
 *   解释：最小的正数 1 没有出现。
 *
 * 提示：
 *   1 <= nums.length <= 10^5
 *   -2^31 <= nums[i] <= 2^31 - 1
 */
class FirstMissingPositiveSolution {
    public int firstMissingPositive(int[] nums) {
        // 在这里写你的解法
        return 0;
    }
}

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositiveSolution s = new FirstMissingPositiveSolution();

        check(s, new int[]{1, 2, 0}, 3, "case1");
        check(s, new int[]{3, 4, -1, 1}, 2, "case2");
        check(s, new int[]{7, 8, 9, 11, 12}, 1, "case3");
        check(s, new int[]{1}, 2, "case4");
    }

    private static void check(FirstMissingPositiveSolution s, int[] nums, int expected, String name) {
        int result = s.firstMissingPositive(nums);
        boolean ok = result == expected;
        System.out.printf("[%s] %s nums=%s -> %d (期望 %d)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.toString(nums),
                result,
                expected);
    }
}
