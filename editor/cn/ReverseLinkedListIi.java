//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1064 👎 0


package leetcode.editor.cn;

//Java：反转链表 II
public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // TO TEST
        ListNode head = ListNode.createListNodes(new Integer[]{1, 2, 3, 4, 5, 6});
        int left = 2;
        int right = 6;
        ListNode.printListNodes(solution.reverseBetween(head, left, right));
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode vh = new ListNode(0, head);
            ListNode pre = vh;
            ListNode next = vh;

            ListNode leftNode = vh;
            ListNode rightNode = vh;
            int cnt = 0;
            //定位左节点，中间链表，右节点
            while (cnt++ < left - 1) {
                pre = pre.next;
                next = next.next;
                leftNode = leftNode.next;
                rightNode = rightNode.next;
            }
            leftNode = leftNode.next;
            while (cnt++ < right + 1) {
                next = next.next;
                rightNode = rightNode.next;
            }
            next = next.next;
            rightNode.next = null;

            ListNode reverse = reverse(leftNode);
            //处理左边节点连接
            pre.next = reverse;
            //处理右边节点连接
            while (reverse.next != null) {
                reverse = reverse.next;
            }
            reverse.next = next;

            return vh.next;
        }

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
    }
//leetcode submit region end(Prohibit modification and deletion)

}