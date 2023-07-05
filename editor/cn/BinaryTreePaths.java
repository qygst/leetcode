//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 804 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：二叉树的所有路径
public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        // TO TEST
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
        List<String> results = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return results;
            dfs(root, "");

            return results;
        }

        void dfs(TreeNode root, String path) {
            //空节点
            if (root == null) return;
            //叶子节点
            if (root.left == null && root.right == null) {
                results.add(path + root.val);
            }

            if (root.left != null) {
                dfs(root.left, path + root.val + "->");
            }
            if (root.right != null) {
                dfs(root.right, path + root.val + "->");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}