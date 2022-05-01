//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1366 👎 0


package leetcode.editor.cn;

//Java：排序链表
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        // TO TEST
        Integer[] nums = new Integer[]{-1, 5, 3, 4, 0};
        ListNode head = ListNode.createListNodes(nums);
        head = solution.sortList(head);
        ListNode.printListNodes(head);
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
        public ListNode sortList(ListNode head) {
            //自底向上
            // intv=1，每一个节点排序合并
            // intv=2，每两个节点排序合并
            //intv=3，每三个节点排序合并。。。直到intv = length，排序合并完成

            //找出链表的长度
            long len = 0L;
            ListNode header = head;
            while (header != null) {
                header = header.next;
                len++;
            }

            header = new ListNode(0);
            header.next = head;
            ListNode merged = header;

            ListNode cur = header;
            for (int intv = 1; intv < len; intv = intv << 1) {
                cur = header.next;
                merged = header;
                while (cur != null) {
                    // 找到前后两个intv长度的子链
                    ListNode h1 = cur;
                    ListNode tail1 = new ListNode(0);
                    tail1.next = h1;
                    ListNode h2 = h1;
                    //找子链2的header
                    for (int i = 0; i < intv && h2 != null; i++) {
                        tail1 = h2;
                        h2 = h2.next;
                    }
                    tail1.next = null;

                    ListNode tail2 = h2;
                    //找子链2的tail
                    for (int i = 1; i < intv && tail2 != null; i++) {
                        tail2 = tail2.next;
                    }
                    //cur指向未处理节点
                    if (tail2 != null) {
                        cur = tail2.next;
                        tail2.next = null;
                    } else {
                        cur = null;
                    }

                    merged.next = merge(h1, h2);
                    //merge指向排序好节点的末尾
                    for (int i = 0; i < 2 * intv && merged != null; i++) {
                        merged = merged.next;
                    }
                }

            }
            return header.next;
        }
       /* public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            // O(n log n)的时间复杂度 考虑使用归并排序（自顶向下、自底向上）
            // 自顶向下 先分割在排序合并
            //分割， 直到只有一个元素
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 分成两个链表，head 和 fast
            fast = slow.next;
            slow.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(fast);
            return merge(left, right);
        }*/

        // 两个有序链表合并成一个有序链表
        private ListNode merge(ListNode left, ListNode right) {
            if (left == null) return right;
            if (right == null) return left;

            ListNode h = new ListNode(0);
            ListNode cur = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;

            }
            cur.next = left == null ? right : left;
            return h.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}