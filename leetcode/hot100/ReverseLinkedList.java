/**
 * LeetCode 206. 反转链表（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/reverse-linked-list/
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 *   输入：head = [1,2,3,4,5]
 *   输出：[5,4,3,2,1]
 *
 * 示例 2：
 *   输入：head = [1,2]
 *   输出：[2,1]
 *
 * 示例 3：
 *   输入：head = []
 *   输出：[]
 *
 * 提示：
 *   链表中节点的数目范围是 [0, 5000]
 *   -5000 <= Node.val <= 5000
 *
 * 进阶：
 *   链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
class ReverseLinkedListNode {
    int val;
    ReverseLinkedListNode next;

    ReverseLinkedListNode(int val) {
        this.val = val;
    }
}

class ReverseLinkedListSolution {
    public ReverseLinkedListNode reverseList(ReverseLinkedListNode head) {
        // 在这里写你的解法
        return null;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedListSolution s = new ReverseLinkedListSolution();

        check(s, new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}, "case1");
        check(s, new int[]{1, 2}, new int[]{2, 1}, "case2");
        check(s, new int[]{}, new int[]{}, "case3");
    }

    private static void check(ReverseLinkedListSolution s, int[] input, int[] expected, String name) {
        ReverseLinkedListNode result = s.reverseList(buildList(input));
        int[] actual = toArray(result);
        boolean ok = java.util.Arrays.equals(actual, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                java.util.Arrays.toString(actual),
                java.util.Arrays.toString(expected));
    }

    private static ReverseLinkedListNode buildList(int... values) {
        ReverseLinkedListNode dummy = new ReverseLinkedListNode(0);
        ReverseLinkedListNode cur = dummy;
        for (int value : values) {
            cur.next = new ReverseLinkedListNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toArray(ReverseLinkedListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
