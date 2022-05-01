//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 379 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        //先序遍历 中→左→右

        //双色法
        public List<Integer> preorderTraversal(TreeNode root) {
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
                    stack.push(new ColorTreeNode(treeNode.right, white));
                    stack.push(new ColorTreeNode(treeNode.left, white));
                    stack.push(new ColorTreeNode(treeNode, gray));
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




    /*// 递归法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        preorder(root, vals);
        return vals;
    }

    private void preorder(TreeNode root, List<Integer> vals) {
        if (root == null) return;

        vals.add(root.val);
        preorder(root.left, vals);
        preorder(root.right, vals);
    }*/

    /*// 迭代法
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.right!=null) stack.push(cur.right);
            if (cur.left!=null) stack.push(cur.left);
        }
        return ans;
    }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}