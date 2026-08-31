/**
 * LeetCode 19. 删除链表的倒数第 N 个结点（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 *   输入：head = [1,2,3,4,5], n = 2
 *   输出：[1,2,3,5]
 *
 * 示例 2：
 *   输入：head = [1], n = 1
 *   输出：[]
 *
 * 示例 3：
 *   输入：head = [1,2], n = 1
 *   输出：[1]
 *
 * 提示：
 *   链表中结点的数目为 sz
 *   1 <= sz <= 30
 *   0 <= Node.val <= 100
 *   1 <= n <= sz
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
class RemoveNthNodeFromEndOfListNode {
    int val;
    RemoveNthNodeFromEndOfListNode next;

    RemoveNthNodeFromEndOfListNode(int val) {
        this.val = val;
    }
}

class RemoveNthNodeFromEndOfListSolution {
    public RemoveNthNodeFromEndOfListNode removeNthFromEnd(RemoveNthNodeFromEndOfListNode head, int n) {
        // 在这里写你的解法
        RemoveNthNodeFromEndOfListNode fast = head;
        RemoveNthNodeFromEndOfListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfListSolution s = new RemoveNthNodeFromEndOfListSolution();

        check(s, new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}, "case1");
        check(s, new int[]{1}, 1, new int[]{}, "case2");
        check(s, new int[]{1, 2}, 1, new int[]{1}, "case3");
    }

    private static void check(RemoveNthNodeFromEndOfListSolution s, int[] input, int n, int[] expected, String name) {
        RemoveNthNodeFromEndOfListNode result = s.removeNthFromEnd(buildList(input), n);
        int[] actual = toArray(result);
        boolean ok = java.util.Arrays.equals(actual, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                java.util.Arrays.toString(actual),
                java.util.Arrays.toString(expected));
    }

    private static RemoveNthNodeFromEndOfListNode buildList(int... values) {
        RemoveNthNodeFromEndOfListNode dummy = new RemoveNthNodeFromEndOfListNode(0);
        RemoveNthNodeFromEndOfListNode cur = dummy;
        for (int value : values) {
            cur.next = new RemoveNthNodeFromEndOfListNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toArray(RemoveNthNodeFromEndOfListNode head) {
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
