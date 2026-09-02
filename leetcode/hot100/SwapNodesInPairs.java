/**
 * LeetCode 24. 两两交换链表中的节点（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 *   输入：head = [1,2,3,4]
 *   输出：[2,1,4,3]
 *
 * 示例 2：
 *   输入：head = []
 *   输出：[]
 *
 * 示例 3：
 *   输入：head = [1]
 *   输出：[1]
 *
 * 提示：
 *   链表中节点的数目在范围 [0, 100] 内
 *   0 <= Node.val <= 100
 */
class SwapNodesInPairsNode {
    int val;
    SwapNodesInPairsNode next;

    SwapNodesInPairsNode(int val) {
        this.val = val;
    }
}

class SwapNodesInPairsSolution {
    public SwapNodesInPairsNode swapPairs(SwapNodesInPairsNode head) {
        // 在这里写你的解法
        if (head == null || head.next == null) return head;
        SwapNodesInPairsNode swap_left = head;
        SwapNodesInPairsNode swap_right = swap_left.next;
        SwapNodesInPairsNode right = swap_right.next;
        swap_left.next = right;
        swap_right.next = swap_left;
        head = swap_right;
        SwapNodesInPairsNode left = swap_left;
        while(swap_left.next!=null&&swap_left!=null){
            swap_left = left.next;
            swap_right = swap_left.next;
            right = swap_right.next;
            swap_left.next = right;
            swap_right.next = swap_left;
            left.next = swap_right;
            left = swap_left;
        }
        return head;
    }
}

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairsSolution s = new SwapNodesInPairsSolution();

        check(s, new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}, "case1");
        check(s, new int[]{}, new int[]{}, "case2");
        check(s, new int[]{1}, new int[]{1}, "case3");
    }

    private static void check(SwapNodesInPairsSolution s, int[] input, int[] expected, String name) {
        SwapNodesInPairsNode result = s.swapPairs(buildList(input));
        int[] actual = toArray(result);
        boolean ok = java.util.Arrays.equals(actual, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                java.util.Arrays.toString(actual),
                java.util.Arrays.toString(expected));
    }

    private static SwapNodesInPairsNode buildList(int... values) {
        SwapNodesInPairsNode dummy = new SwapNodesInPairsNode(0);
        SwapNodesInPairsNode cur = dummy;
        for (int value : values) {
            cur.next = new SwapNodesInPairsNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toArray(SwapNodesInPairsNode head) {
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
