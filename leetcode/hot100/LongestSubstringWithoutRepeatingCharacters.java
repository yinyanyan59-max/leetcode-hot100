import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3. 无重复的字符的最长子串（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.isEmpty()){
            return 0;
        }
        int max_len = 0;
        int fast = 0;
        for(int low = 0; low < s.length()-1; low=fast){
            Map<String, Integer> hashmap = new HashMap<>();
            hashmap.put(String.valueOf(s.charAt(low)), 0);
            fast = low + 1;
            int len = 1;
            while (!hashmap.containsKey(String.valueOf(s.charAt(fast)))){
                hashmap.put(String.valueOf(s.charAt(fast)), 0);
                fast++;
                len++;
                if (fast >= s.length()){
                    break;
                }
            }
            if (len > max_len){
                max_len= len;
            }

        }
        return max_len;
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

