//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 915 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树的最近公共祖先
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        // TO TEST
        TreeNode root = TreeNode.createBiTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode res = solution.lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {

        boolean find = false;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 方法一：到两个节点的path中最近的公共节点

            /*List<TreeNode> ppath = new ArrayList<>();
            List<TreeNode> qpath = new ArrayList<>();
            dfs(root, ppath, p);
            find = false;
            dfs(root, qpath, q);

            TreeNode res = root;
            for (int i = 0; i < ppath.size() && i < qpath.size(); i++) {
                if (ppath.get(i).equals(qpath.get(i))) res = ppath.get(i);
            }

            return res;*/


            //方法二：利用BST的特性。
            // （root-p）*（root-q）
            // 1.为零，说明一个节点为root（返回root）；
            // 2.负数，说明pq在root两侧（返回root）；
            // 3.为正数，说明pq在root的同一子树上
            while ((root.val - p.val) * (root.val - q.val) > 0) {
                root = root.val > p.val ? root.left : root.right;
            }
            return root;
        }

        public void dfs(TreeNode root, List<TreeNode> path, TreeNode t) {
            // 找到根节点到指定节点的路径
            if (find || root == null) return;

            path.add(root);

            if (root == t) {
                find = true;
                return;
            }


            dfs(root.left, path, t);
            dfs(root.right, path, t);
            // 如果当前节点左右子树都没有目标节点，则把当前节点出栈
            if (!find) {
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}