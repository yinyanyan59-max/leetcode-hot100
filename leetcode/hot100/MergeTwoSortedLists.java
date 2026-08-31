/**
 * LeetCode 21. 合并两个有序链表（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *   输入：l1 = [1,2,4], l2 = [1,3,4]
 *   输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *   输入：l1 = [], l2 = []
 *   输出：[]
 *
 * 示例 3：
 *   输入：l1 = [], l2 = [0]
 *   输出：[0]
 *
 * 提示：
 *   两个链表的节点数目范围是 [0, 50]
 *   -100 <= Node.val <= 100
 *   l1 和 l2 均按 非递减顺序 排列
 */
class MergeTwoSortedListsNode {
    int val;
    MergeTwoSortedListsNode next;

    MergeTwoSortedListsNode(int val) {
        this.val = val;
    }
}

class MergeTwoSortedListsSolution {
    public MergeTwoSortedListsNode mergeTwoLists(MergeTwoSortedListsNode list1, MergeTwoSortedListsNode list2) {
        // 在这里写你的解法
        return null;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedListsSolution s = new MergeTwoSortedListsSolution();

        check(s, new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}, "case1");
        check(s, new int[]{}, new int[]{}, new int[]{}, "case2");
        check(s, new int[]{}, new int[]{0}, new int[]{0}, "case3");
    }

    private static void check(MergeTwoSortedListsSolution s, int[] a, int[] b, int[] expected, String name) {
        MergeTwoSortedListsNode result = s.mergeTwoLists(buildList(a), buildList(b));
        int[] actual = toArray(result);
        boolean ok = java.util.Arrays.equals(actual, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                java.util.Arrays.toString(actual),
                java.util.Arrays.toString(expected));
    }

    private static MergeTwoSortedListsNode buildList(int... values) {
        MergeTwoSortedListsNode dummy = new MergeTwoSortedListsNode(0);
        MergeTwoSortedListsNode cur = dummy;
        for (int value : values) {
            cur.next = new MergeTwoSortedListsNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toArray(MergeTwoSortedListsNode head) {
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
