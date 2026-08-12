/**
 * LeetCode 234. 回文链表（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/palindrome-linked-list/
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *   输入：head = [1,2,2,1]
 *   输出：true
 *
 * 示例 2：
 *   输入：head = [1,2]
 *   输出：false
 *
 * 提示：
 *   链表中节点数目在范围 [1, 10^5] 内
 *   0 <= Node.val <= 9
 *
 * 进阶：
 *   你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
class PalindromeLinkedListNode {
    int val;
    PalindromeLinkedListNode next;

    PalindromeLinkedListNode(int val) {
        this.val = val;
    }
}

class PalindromeLinkedListSolution {
    public boolean isPalindrome(PalindromeLinkedListNode head) {
        // 在这里写你的解法
        return false;
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedListSolution s = new PalindromeLinkedListSolution();

        check(s, new int[]{1, 2, 2, 1}, true, "case1");
        check(s, new int[]{1, 2}, false, "case2");
        check(s, new int[]{1}, true, "case3");
    }

    private static void check(PalindromeLinkedListSolution s, int[] input, boolean expected, String name) {
        boolean result = s.isPalindrome(buildList(input));
        boolean ok = result == expected;
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }

    private static PalindromeLinkedListNode buildList(int... values) {
        PalindromeLinkedListNode dummy = new PalindromeLinkedListNode(0);
        PalindromeLinkedListNode cur = dummy;
        for (int value : values) {
            cur.next = new PalindromeLinkedListNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }
}
