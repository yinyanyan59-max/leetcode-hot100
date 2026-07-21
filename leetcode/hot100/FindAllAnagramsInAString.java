import java.util.*;

/**
 * LeetCode 438. 找到字符串中所有字母异位词（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1：
 *   输入: s = "cbaebabacd", p = "abc"
 *   输出: [0,6]
 *   解释:
 *     起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 *     起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2：
 *   输入: s = "abab", p = "ab"
 *   输出: [0,1,2]
 *   解释:
 *     起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 *     起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 *     起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示：
 *   1 <= s.length, p.length <= 3 * 10^4
 *   s 和 p 仅包含小写字母
 */
class FindAllAnagramsInAStringSolution {
    public List<Integer> findAnagrams(String s, String p) {
        // 在这里写你的解法
        char[] strs1 = p.toCharArray();
        Arrays.sort(strs1);
        char[] strs2 = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<=strs2.length-strs1.length;i++){
            char[] strs = new char[strs1.length];
            for (int j=i;j <= (i + strs1.length-1); j++){
                strs[j-i] = strs2[j];
            }
            Arrays.sort(strs);
            if(Arrays.equals(strs, strs1)){
                list.add(i);
            }
        }

        return list;
    }
}

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        FindAllAnagramsInAStringSolution sol = new FindAllAnagramsInAStringSolution();

        check(sol, "cbaebabacd", "abc", Arrays.asList(0, 6), "case1");
        check(sol, "abab", "ab", Arrays.asList(0, 1, 2), "case2");
    }

    private static void check(FindAllAnagramsInAStringSolution sol, String s, String p,
                              List<Integer> expected, String name) {
        List<Integer> result = sol.findAnagrams(s, p);
        List<Integer> sortedResult = new ArrayList<>(result);
        List<Integer> sortedExpected = new ArrayList<>(expected);
        sortedResult.sort(Integer::compareTo);
        sortedExpected.sort(Integer::compareTo);
        boolean ok = sortedResult.equals(sortedExpected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }
}
