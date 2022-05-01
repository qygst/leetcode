//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。 
//
// 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。 
//
// 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random 
//--> y 。 
//
// 返回复制链表的头节点。 
//
// 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 你的代码 只 接受原链表的头节点 head 作为传入参数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 
//输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 1000 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 
// Related Topics 哈希表 链表 👍 764 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：复制带随机指针的链表
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        // TO TEST
        Node n1 = buildNode();
        printVal(n1);
        printRandom(n1);

        n1 = solution.copyRandomList(n1);
        printVal(n1);
        printRandom(n1);

    }

    private static Node buildNode() {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        return n1;
    }

    private static void printVal(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println();
    }

    private static void printRandom(Node head) {
        Node p = head;
        while (p != null) {
            if (p.random == null) {
                System.out.print("null" + ",");
            } else {
                System.out.print(p.random.val + ",");
            }
            p = p.next;
        }
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return head;
            // key为旧node，value为新node
            Map<Node, Node> dict = new HashMap<>();
            Node p = head;
            Node header = new Node(head.val);
            dict.put(p, header);

            //复制所有节点
            while (p.next != null) {
                Node next = new Node(p.next.val);
                dict.get(p).next = next;
                dict.put(p.next, next);

                p = p.next;
            }

            //处理random节点
            p = head;
            while (p != null) {
                dict.get(p).random = dict.get(p.random);
                p = p.next;
            }
            return header;

        }

        /*public Node copyRandomList(Node head) {
            // 先遍历链表复制每个节点，1->2->3->4->5 变成 1->1‘->2->2’->3->3‘->4->4’->5->5‘
            Node p = head;
            while (p != null) {
                Node next = p.next;
                Node cp = new Node(p.val);
                cp.next = next;
                p.next = cp;

                p = next;
            }

            p = head;
            // random指向新new出的节点，此处要注意random要是新生成的节点
            while (p != null && p.next != null) {
                Node next = p.next;
                if (p.random == null) {
                    next.random = null;
                } else {
                    next.random = p.random.next;
                }
                p = next.next;
            }

            // 再把复制节点抽离出来，并将原链表复原
            Node header = new Node(-1);
            header.next = head;
            Node cp = header;
            p = head;
            while (p != null && p.next != null) {
                cp.next = p.next;
                p.next = cp.next.next;
                p = p.next;
                cp = cp.next;
            }
            printVal(header.next);
            printRandom(header.next);
            return header.next;

        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}