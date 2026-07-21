import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49. 字母异位词分组（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/group-anagrams/
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1：
 *   输入: strs = ["eat","tea","tan","ate","nat","bat"]
 *   输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *   解释:
 *     - "bat" 没有字母异位词，所以单独一组
 *     - "nat" 和 "tan" 是字母异位词
 *     - "ate"、"eat" 和 "tea" 是字母异位词
 *
 * 示例 2：
 *   输入: strs = [""]
 *   输出: [[""]]
 *
 * 示例 3：
 *   输入: strs = ["a"]
 *   输出: [["a"]]
 *
 * 提示：
 *   1 <= strs.length <= 10^4
 *   0 <= strs[i].length <= 100
 *   strs[i] 仅包含小写字母
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution s = new Solution();

        // Case 1
        check(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                Arrays.asList(
                        Arrays.asList("bat"),
                        Arrays.asList("nat", "tan"),
                        Arrays.asList("ate", "eat", "tea")
                ),
                "case1");

        // Case 2
        check(s.groupAnagrams(new String[]{""}),
                Arrays.asList(Arrays.asList("")),
                "case2");

        // Case 3
        check(s.groupAnagrams(new String[]{"a"}),
                Arrays.asList(Arrays.asList("a")),
                "case3");
    }

    /** 结果组的顺序、组内顺序都可以任意，这里做标准化后再比较 */
    private static void check(List<List<String>> result, List<List<String>> expected, String name) {
        boolean ok = normalize(result).equals(normalize(expected));
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }

    private static List<List<String>> normalize(List<List<String>> groups) {
        if (groups == null) {
            return null;
        }
        List<List<String>> copy = new java.util.ArrayList<>();
        for (List<String> g : groups) {
            List<String> one = new java.util.ArrayList<>(g);
            java.util.Collections.sort(one);
            copy.add(one);
        }
        copy.sort((a, b) -> {
            String sa = String.join(",", a);
            String sb = String.join(",", b);
            return sa.compareTo(sb);
        });
        return copy;
    }
}
