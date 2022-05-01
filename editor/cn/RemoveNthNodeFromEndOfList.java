//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1229 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode head =ListNode.createListNodes(new Integer[]{1,2});
        head = solution.removeNthFromEnd(head, 2);
        System.out.println(Arrays.toString(ListNode.printListNodes(head)));;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n <= 0) return null;
            if (head.next == null && n==1) return null;
            ListNode fast = head;
            ListNode slow = head;
            ListNode slowPre = head;
            while (--n > 0 && fast != null) {
                fast = fast.next;
            }
            if (fast.next == null) return head.next;
            while (fast.next != null) {
                fast = fast.next;
                slowPre = slow;
                slow = slow.next;
            }
            slowPre.next = slow.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
