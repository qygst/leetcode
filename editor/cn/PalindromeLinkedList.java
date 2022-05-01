//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1171 👎 0


package leetcode.editor.cn;

//Java：回文链表
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // TO TEST
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
        public boolean isPalindrome(ListNode head) {
            //把链表分为两半，后半部分反转后和前半部分比较是否相等

            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 分成两个链表，head 和 fast
            fast = slow.next;
            slow.next = null;
            fast = reverseList(fast);

            while (fast != null) {
                if (fast.val != head.val) return false;
                fast = fast.next;
                head = head.next;
            }
            return true;

        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode prev = null;
            ListNode cur = head;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;

                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}