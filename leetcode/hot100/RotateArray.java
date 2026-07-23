import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 189. 轮转数组（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/rotate-array/
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1：
 *   输入: nums = [1,2,3,4,5,6,7], k = 3
 *   输出: [5,6,7,1,2,3,4]
 *   解释:
 *     向右轮转 1 步: [7,1,2,3,4,5,6]
 *     向右轮转 2 步: [6,7,1,2,3,4,5]
 *     向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2：
 *   输入：nums = [-1,-100,3,99], k = 2
 *   输出：[3,99,-1,-100]
 *   解释:
 *     向右轮转 1 步: [99,-1,-100,3]
 *     向右轮转 2 步: [3,99,-1,-100]
 *
 * 提示：
 *   1 <= nums.length <= 10^5
 *   -2^31 <= nums[i] <= 2^31 - 1
 *   0 <= k <= 10^5
 *
 * 进阶：
 *   尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *   你可以使用空间复杂度为 O(1) 的原地算法解决这个问题吗？
 */
class RotateArraySolution {
    public void reverse(int[] nums, int left, int right){
        int tmp = 0;
        while(right>left){
            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            right--;
            left++;
        }

    }

    public void rotate(int[] nums, int k) {
        // 在这里写你的解法
        int k_true = k % (nums.length);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k_true-1);
        reverse(nums, k_true, nums.length - 1);
    }
}

public class RotateArray {
    public static void main(String[] args) {
        RotateArraySolution s = new RotateArraySolution();

        check(s, new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}, "case1");
        check(s, new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}, "case2");
        check(s, new int[]{1, 2}, 3, new int[]{2, 1}, "case3");
    }

    private static void check(RotateArraySolution s, int[] nums, int k, int[] expected, String name) {
        s.rotate(nums, k);
        boolean ok = Arrays.equals(nums, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.toString(nums),
                Arrays.toString(expected));
    }
}
