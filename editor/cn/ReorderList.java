//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 702 👎 0


package leetcode.editor.cn;

//Java：重排链表
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {

            // 先把链表用快慢指针分为前后两半
            // 把后半部分反转
            // 前后两部分交叉连接
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 分成两个链表，head 和 fast
            fast = slow.next;
            slow.next = null;

            fast = reverse(fast);

            head = alternatelyLink(head, fast);
        }

        // 反转链表
        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        // 交替连接两个链表
        private ListNode alternatelyLink(ListNode h1, ListNode h2) {
            if (h1 == null) return h2;
            if (h2 == null) return h1;
            ListNode head = new ListNode(0);
            ListNode p = head;
            while (h1 != null && h2 != null) {
                ListNode next1 = h1.next;
                ListNode next2 = h2.next;
                p.next = h1;
                h1.next = h2;
                h2.next = next1;

                p = h2;
                h1 = next1;
                h2 = next2;
            }
            if (h1 == null) {
                p.next = h2;
            }
            if (h2 == null) {
                p.next = h1;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}