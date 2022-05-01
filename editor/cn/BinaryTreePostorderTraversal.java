//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 457 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 后序  左→右→中

        //双色法
        // 根节点先入栈，栈顶元素为灰色则输出，为白色，则弹出同时将左右子节点按照中→右→左入栈，中节点变灰
        // 入栈顺序和实际输出顺序相反
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            if (root == null) return vals;

            int white = 0;
            int gray = 1;
            Stack<ColorTreeNode> stack = new Stack<>();
            stack.push(new ColorTreeNode(root, white));
            while (!stack.isEmpty()) {
                ColorTreeNode node = stack.pop();
                TreeNode treeNode = node.treeNode;
                int color = node.color;
                if (treeNode == null) continue;

                if (color == white) {
                    stack.push(new ColorTreeNode(treeNode, gray));
                    stack.push(new ColorTreeNode(treeNode.right, white));
                    stack.push(new ColorTreeNode(treeNode.left, white));
                } else {
                    vals.add(treeNode.val);
                }
            }
            return vals;
        }

        class ColorTreeNode {
            private TreeNode treeNode;
            private int color;

            public ColorTreeNode(TreeNode treeNode, int color) {
                this.treeNode = treeNode;
                this.color = color;
            }
        }




        /*//递归
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            if (root == null) return values;

            postorder(root, values);
            return values;
        }
        private void postorder(TreeNode root, List<Integer> values) {
            if (root == null) return;

            postorder(root.left, values);
            postorder(root.right, values);
            values.add(root.val);
        }*/

        /*//单次迭代
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            TreeNode cur = root;
            TreeNode latestVisit = root;
            Stack<TreeNode> stack = new Stack<>();

            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.peek();
                if (cur.right == null || latestVisit == cur.right) {
                    ans.add(cur.val);
                    stack.pop();
                    latestVisit = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
            return ans;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}