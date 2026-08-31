/**
 * LeetCode 2. 两数相加（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/add-two-numbers/
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 *   输入：l1 = [2,4,3], l2 = [5,6,4]
 *   输出：[7,0,8]
 *   解释：342 + 465 = 807
 *
 * 示例 2：
 *   输入：l1 = [0], l2 = [0]
 *   输出：[0]
 *
 * 示例 3：
 *   输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *   输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *   每个链表中的节点数在范围 [1, 100] 内
 *   0 <= Node.val <= 9
 *   题目数据保证列表表示的数字不含前导零
 */
class AddTwoNumbersNode {
    int val;
    AddTwoNumbersNode next;

    AddTwoNumbersNode(int val) {
        this.val = val;
    }
}

class AddTwoNumbersSolution {
    public AddTwoNumbersNode addTwoNumbers(AddTwoNumbersNode l1, AddTwoNumbersNode l2) {
        // 在这里写你的解法
        return null;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbersSolution s = new AddTwoNumbersSolution();

        check(s, new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}, "case1");
        check(s, new int[]{0}, new int[]{0}, new int[]{0}, "case2");
        check(s, new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1}, "case3");
    }

    private static void check(AddTwoNumbersSolution s, int[] a, int[] b, int[] expected, String name) {
        AddTwoNumbersNode result = s.addTwoNumbers(buildList(a), buildList(b));
        int[] actual = toArray(result);
        boolean ok = java.util.Arrays.equals(actual, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                java.util.Arrays.toString(actual),
                java.util.Arrays.toString(expected));
    }

    private static AddTwoNumbersNode buildList(int... values) {
        AddTwoNumbersNode dummy = new AddTwoNumbersNode(0);
        AddTwoNumbersNode cur = dummy;
        for (int value : values) {
            cur.next = new AddTwoNumbersNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toArray(AddTwoNumbersNode head) {
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
