/**
 * LeetCode 76. 最小覆盖子串（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/minimum-window-substring/
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，返回空字符串 ""。
 *
 * 注意：
 *   对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *   如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *   输入：s = "ADOBECODEBANC", t = "ABC"
 *   输出："BANC"
 *   解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 *   输入：s = "a", t = "a"
 *   输出："a"
 *
 * 示例 3：
 *   输入：s = "a", t = "aa"
 *   输出：""
 *   解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串。
 *
 * 提示：
 *   1 <= s.length, t.length <= 10^5
 *   s 和 t 由英文字母组成
 */
class MinimumWindowSubstringSolution {
    public String minWindow(String s, String t) {
        // 在这里写你的解法
        int[] need = new int[128];
        int[] window = new int[128];
        int valid = 0;
        int count = 0;
        for(char c:t.toCharArray()){
            need[c]++;
        }
        for (int num : need) {
            if (num != 0) {
                count++;
            }
        }
        int left = 0;
        int start = 0;
        int min_len = Integer.MAX_VALUE;
        char[] str_s = new char[s.length()];
        str_s = s.toCharArray();
        for(int right=0;right<s.length();right++){
            if(need[s.charAt(right)]>0){
                window[s.charAt(right)] ++;
                if(window[s.charAt(right)]==need[s.charAt(right)]){
                    valid++;
                }
            }
            if (valid == count){
                while(valid == count && left <= right){
                    if (right - left < min_len) {
                        start = left;
                        min_len = right - left + 1;
                    }
                    if(need[s.charAt(left)]>0){

                        if(window[s.charAt(left)]==need[s.charAt(left)]){
                            valid--;
                        }
                        window[s.charAt(left)] --;
                    }
                    left++;
                }
            }
        }
        if (min_len<=s.length()){
            return s.substring(start, start+min_len);
        }

        return "";
    }
}

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstringSolution sol = new MinimumWindowSubstringSolution();

        check(sol, "ADOBECODEBANC", "ABC", "BANC", "case1");
        check(sol, "a", "a", "a", "case2");
        check(sol, "a", "aa", "", "case3");
    }

    private static void check(MinimumWindowSubstringSolution sol, String s, String t, String expected, String name) {
        String result = sol.minWindow(s, t);
        boolean ok = expected.equals(result);
        System.out.printf("[%s] %s -> \"%s\" (期望 \"%s\")%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }
}
