/**
 * LeetCode 160. 相交链表（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 示例 1：
 *   输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 *   输出：Intersected at '8'
 *
 * 示例 2：
 *   输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 *   输出：Intersected at '2'
 *
 * 示例 3：
 *   输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *   输出：No intersection
 *
 * 提示：
 *   listA 中节点数目为 m
 *   listB 中节点数目为 n
 *   1 <= m, n <= 3 * 10^4
 *   1 <= Node.val <= 10^5
 *   0 <= skipA < m
 *   0 <= skipB < n
 *   如果 listA 和 listB 没有交点，intersectVal 为 0
 *   如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 *
 * 进阶：
 *   你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class IntersectionOfTwoLinkedListsSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 在这里写你的解法
        return null;
    }
}

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        IntersectionOfTwoLinkedListsSolution s = new IntersectionOfTwoLinkedListsSolution();

        ListNode common1 = buildList(8, 4, 5);
        ListNode headA1 = link(buildList(4, 1), common1);
        ListNode headB1 = link(buildList(5, 6, 1), common1);
        check(s, headA1, headB1, common1, "case1");

        ListNode common2 = buildList(2, 4);
        ListNode headA2 = link(buildList(1, 9, 1), common2);
        ListNode headB2 = link(buildList(3), common2);
        check(s, headA2, headB2, common2, "case2");

        check(s, buildList(2, 6, 4), buildList(1, 5), null, "case3");
    }

    private static void check(IntersectionOfTwoLinkedListsSolution s, ListNode headA, ListNode headB, ListNode expected, String name) {
        ListNode result = s.getIntersectionNode(headA, headB);
        boolean ok = result == expected;
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result == null ? "null" : result.val,
                expected == null ? "null" : expected.val);
    }

    private static ListNode buildList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int value : values) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static ListNode link(ListNode head, ListNode tail) {
        if (head == null) {
            return tail;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tail;
        return head;
    }
}
