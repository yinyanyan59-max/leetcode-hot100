import java.util.Arrays;

/**
 * LeetCode 283. 移动零（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/move-zeroes/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1：
 *   输入: nums = [0,1,0,3,12]
 *   输出: [1,3,12,0,0]
 *
 * 示例 2：
 *   输入: nums = [0]
 *   输出: [0]
 *
 * 提示：
 *   1 <= nums.length <= 10^4
 *   -2^31 <= nums[i] <= 2^31 - 1
 *
 * 进阶：你能尽量减少完成操作所需的交换次数吗？
 */
class MoveZeroesSolution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroesSolution s = new MoveZeroesSolution();

        check(s, new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}, "case1");
        check(s, new int[]{0}, new int[]{0}, "case2");
        check(s, new int[]{1, 2, 3}, new int[]{1, 2, 3}, "case3");
        check(s, new int[]{0, 0, 1}, new int[]{1, 0, 0}, "case4");
    }

    private static void check(MoveZeroesSolution s, int[] nums, int[] expected, String name) {
        s.moveZeroes(nums);
        boolean ok = Arrays.equals(nums, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.toString(nums),
                Arrays.toString(expected));
    }
}
