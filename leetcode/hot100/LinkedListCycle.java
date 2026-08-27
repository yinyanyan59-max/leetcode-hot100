/**
 * LeetCode 141. 环形链表（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/linked-list-cycle/
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统 内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 *   输入：head = [3,2,0,-4], pos = 1
 *   输出：true
 *   解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *   输入：head = [1,2], pos = 0
 *   输出：true
 *   解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *   输入：head = [1], pos = -1
 *   输出：false
 *   解释：链表中没有环。
 *
 * 提示：
 *   链表中节点的数目范围是 [0, 10^4]
 *   -10^5 <= Node.val <= 10^5
 *   pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 进阶：
 *   你能用 O(1)（即，常量）内存解决此问题吗？
 */
class LinkedListCycleNode {
    int val;
    LinkedListCycleNode next;

    LinkedListCycleNode(int val) {
        this.val = val;
    }
}

class LinkedListCycleSolution {
    public boolean hasCycle(LinkedListCycleNode head) {
        // 在这里写你的解法
        return false;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycleSolution s = new LinkedListCycleSolution();

        check(s, buildCycle(new int[]{3, 2, 0, -4}, 1), true, "case1");
        check(s, buildCycle(new int[]{1, 2}, 0), true, "case2");
        check(s, buildCycle(new int[]{1}, -1), false, "case3");
    }

    private static void check(LinkedListCycleSolution s, LinkedListCycleNode head, boolean expected, String name) {
        boolean result = s.hasCycle(head);
        boolean ok = result == expected;
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }

    private static LinkedListCycleNode buildCycle(int[] values, int pos) {
        if (values.length == 0) {
            return null;
        }
        LinkedListCycleNode dummy = new LinkedListCycleNode(0);
        LinkedListCycleNode cur = dummy;
        LinkedListCycleNode cycleNode = null;
        for (int i = 0; i < values.length; i++) {
            cur.next = new LinkedListCycleNode(values[i]);
            cur = cur.next;
            if (i == pos) {
                cycleNode = cur;
            }
        }
        if (pos >= 0) {
            cur.next = cycleNode;
        }
        return dummy.next;
    }
}
