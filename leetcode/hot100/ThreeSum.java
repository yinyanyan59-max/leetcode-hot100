/**
 * LeetCode 15. 三数之和（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/3sum/
 *
 * 给你一个整数数组 nums，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足
 * i != j、i != k 且 j != k，同时还满足 nums[i] + nums[j] + nums[k] == 0。
 *
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *   输入：nums = [-1,0,1,2,-1,-4]
 *   输出：[[-1,-1,2],[-1,0,1]]
 *   解释：nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0。
 *         nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0。
 *         不重复的三元组是 [-1,0,1] 和 [-1,-1,2]。
 *
 * 示例 2：
 *   输入：nums = [0,1,1]
 *   输出：[]
 *
 * 示例 3：
 *   输入：nums = [0,0,0]
 *   输出：[[0,0,0]]
 *
 * 提示：
 *   3 <= nums.length <= 3000
 *   -10^5 <= nums[i] <= 10^5
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 在这里写你的解法
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len-2;i++){
            if(nums[i]>0){
                break;
            }
            int j = i+1;
            int k = len - 1;
            while (k>j){
                if(nums[i]+nums[j]+nums[k] == 0){
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    list.add(ls);
                    break;
                } else if (nums[i]+nums[j]+nums[k] > 0) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return list;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSumSolution s = new ThreeSumSolution();

        check(s, new int[]{-1, 0, 1, 2, -1, -4},
                Arrays.asList(
                        Arrays.asList(-1, -1, 2),
                        Arrays.asList(-1, 0, 1)
                ),
                "case1");
        check(s, new int[]{0, 1, 1}, new ArrayList<>(), "case2");
        check(s, new int[]{0, 0, 0},
                Arrays.asList(Arrays.asList(0, 0, 0)),
                "case3");
    }

    private static void check(ThreeSumSolution s, int[] nums, List<List<Integer>> expected, String name) {
        List<List<Integer>> result = s.threeSum(nums);
        boolean ok = normalize(result).equals(normalize(expected));
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }

    private static List<List<Integer>> normalize(List<List<Integer>> groups) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> g : groups) {
            List<Integer> one = new ArrayList<>(g);
            one.sort(Integer::compareTo);
            copy.add(one);
        }
        copy.sort((a, b) -> {
            String sa = a.toString();
            String sb = b.toString();
            return sa.compareTo(sb);
        });
        return copy;
    }
}
