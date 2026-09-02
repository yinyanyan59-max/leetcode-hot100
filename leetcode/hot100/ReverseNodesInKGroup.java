/**
 * LeetCode 25. K 个一组翻转链表（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
 * 那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 *   输入：head = [1,2,3,4,5], k = 2
 *   输出：[2,1,4,3,5]
 *
 * 示例 2：
 *   输入：head = [1,2,3,4,5], k = 3
 *   输出：[3,2,1,4,5]
 *
 * 提示：
 *   链表中的节点数目为 n
 *   1 <= k <= n <= 5000
 *   0 <= Node.val <= 1000
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
class ReverseNodesInKGroupNode {
    int val;
    ReverseNodesInKGroupNode next;

    ReverseNodesInKGroupNode(int val) {
        this.val = val;
    }
}

class ReverseNodesInKGroupSolution {
    public ReverseNodesInKGroupNode reverseKGroup(ReverseNodesInKGroupNode head, int k) {
        // 在这里写你的解法
        return null;
    }
}

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ReverseNodesInKGroupSolution s = new ReverseNodesInKGroupSolution();

        check(s, new int[]{1, 2, 3, 4, 5}, 2, new int[]{2, 1, 4, 3, 5}, "case1");
        check(s, new int[]{1, 2, 3, 4, 5}, 3, new int[]{3, 2, 1, 4, 5}, "case2");
        check(s, new int[]{1}, 1, new int[]{1}, "case3");
    }

    private static void check(ReverseNodesInKGroupSolution s, int[] input, int k, int[] expected, String name) {
        ReverseNodesInKGroupNode result = s.reverseKGroup(buildList(input), k);
        int[] actual = toArray(result);
        boolean ok = java.util.Arrays.equals(actual, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                java.util.Arrays.toString(actual),
                java.util.Arrays.toString(expected));
    }

    private static ReverseNodesInKGroupNode buildList(int... values) {
        ReverseNodesInKGroupNode dummy = new ReverseNodesInKGroupNode(0);
        ReverseNodesInKGroupNode cur = dummy;
        for (int value : values) {
            cur.next = new ReverseNodesInKGroupNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toArray(ReverseNodesInKGroupNode head) {
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
