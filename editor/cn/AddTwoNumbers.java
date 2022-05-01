//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4975 👎 0

package leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

    }
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//Java：两数相加
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode res = new ListNode(0);
            ListNode cur = res;
            ListNode p1 = l1;
            ListNode p2 = l2;
            int carry = 0;
            while (p1 != null || p2 != null) {
                int val1 = p1 != null ? p1.val : 0;
                int val2 = p2 != null ? p2.val : 0;
                int sum = val1 + val2 + carry;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }

                carry = sum / 10;
            }

            if (carry != 0) {
                cur.next = new ListNode(carry);
            }
            return res.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
