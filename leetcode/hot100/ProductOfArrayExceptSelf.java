import java.util.Arrays;

/**
 * LeetCode 238. 除自身以外数组的乘积（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/product-of-array-except-self/
 *
 * 给你一个整数数组 nums，返回数组 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 题目数据保证数组 nums 之中任意元素的全部前缀元素和后缀的乘积都在 32 位整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1：
 *   输入: nums = [1,2,3,4]
 *   输出: [24,12,8,6]
 *
 * 示例 2：
 *   输入: nums = [-1,1,0,-3,3]
 *   输出: [0,0,9,0,0]
 *
 * 提示：
 *   2 <= nums.length <= 10^5
 *   -30 <= nums[i] <= 30
 *   保证数组 nums 之中任意元素的全部前缀元素和后缀的乘积都在 32 位整数范围内
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
class ProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        // 在这里写你的解法
        int[] left = new int[nums.length];
        int[] right = new  int[nums.length];
        int[] result = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 1; i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
            right[nums.length-i-1] = right[nums.length-i] * nums[nums.length - i];
        }
        for(int i = 0; i<nums.length;i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
}

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelfSolution s = new ProductOfArrayExceptSelfSolution();

        check(s, new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}, "case1");
        check(s, new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}, "case2");
    }

    private static void check(ProductOfArrayExceptSelfSolution s, int[] nums, int[] expected, String name) {
        int[] result = s.productExceptSelf(nums);
        boolean ok = Arrays.equals(result, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.toString(result),
                Arrays.toString(expected));
    }
}
