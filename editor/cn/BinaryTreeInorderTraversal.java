//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 739 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

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
        /* //递归
         public List<Integer> inorderTraversal(TreeNode root) {
             if (root == null) return new ArrayList<>();
             List<Integer> values = new ArrayList<>();
             inorder(root, values);
             return values;
         }

         private void inorder(TreeNode root, List<Integer> vals) {
             if (root == null) return;

             inorder(root.left, vals);
             vals.add(root.val);
             inorder(root.right, vals);
         }*/

        //双色法，每个节点第一次入栈为白色，第二次入栈为灰色，灰色在栈顶时即可输出，入栈顺序为右->自己->左
        //根节点入栈，然后对栈顶元素进行操作，先弹出，再右->自己（变灰）->左入栈
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<ColorTreeNode> stack = new Stack<>();
            int white = 0;
            int gray = 1;
            stack.push(new ColorTreeNode(root, white));
            while (!stack.isEmpty()) {
                ColorTreeNode node = stack.pop();
                int color = node.color;
                TreeNode treeNode = node.treeNode;

                if (treeNode == null) continue;

                if (color == white) {
                    stack.push(new ColorTreeNode(treeNode.right, white));
                    stack.push(new ColorTreeNode(treeNode, gray));
                    stack.push(new ColorTreeNode(treeNode.left, white));
                } else {
                    res.add(treeNode.val);
                }
            }

            return res;
        }

        private class ColorTreeNode {
            TreeNode treeNode;
            int color;

            public ColorTreeNode(TreeNode treeNode, int color) {
                this.treeNode = treeNode;
                this.color = color;
            }
        }


        /*//迭代
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            TreeNode cur = root;
            Stack<TreeNode> stack = new Stack<>();
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
            return ans;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}