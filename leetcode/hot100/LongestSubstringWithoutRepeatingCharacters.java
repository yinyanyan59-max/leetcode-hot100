import java.util.Arrays;

/**
 * LeetCode 3. 无重复的字符的最长子串（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // last[c] 记录字符 c 最近一次出现的位置（-1 表示未出现）
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int left = 0;  // 当前窗口左边界（包含）
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last[c] >= left) {
                // c 已在窗口内出现过，移动左边界到 c 上次出现位置的右侧
                left = last[c] + 1;
            }
            last[c] = right;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersSolution s = new LongestSubstringWithoutRepeatingCharactersSolution();

        check(s, "abcabcbb", 3, "case1");
        check(s, "bbbbb", 1, "case2");
        check(s, "pwwkew", 3, "case3");
        check(s, "", 0, "case4");
    }

    private static void check(LongestSubstringWithoutRepeatingCharactersSolution s, String input, int expected, String name) {
        int result = s.lengthOfLongestSubstring(input);
        boolean ok = result == expected;
        System.out.printf("[%s] %s -> %d (期望 %d)%n",
                ok ? "PASS" : "FAIL",
                name + ":" + input,
                result,
                expected);
    }
}

