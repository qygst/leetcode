//返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。 
//
// (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right
// 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。） 
//
// 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。 
//
// 
//
// 示例： 
//
// 输入：[8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值互不相同 
// 
// Related Topics 栈 树 二叉搜索树 数组 二叉树 单调栈 
// 👍 184 👎 0


package leetcode.editor.cn;

//Java：No.1008 - 前序遍历构造二叉搜索树

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 2};
        TreeNode root = solution.bstFromPreorder(nums);
        System.out.println(root);
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
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder.length == 0) return null;
            TreeNode root = rePreorder(preorder, 0, preorder.length - 1);
            return root;
        }

        private TreeNode rePreorder(int[] preorder, int i, int j) {
            if (i > j) return null;
            if (i == j) return new TreeNode(preorder[i]);

            TreeNode parent = new TreeNode(preorder[i]);
            int index = find1stBigger(preorder, i + 1, j, preorder[i]);
            parent.left = rePreorder(preorder, i + 1, index - 1);
            parent.right = rePreorder(preorder, index, j);


            return parent;
        }

        //找到第一个比flag大的值的下标
        private int find1stBigger(int[] preorder, int left, int right, int flag) {
            for (int i = left; i < right + 1; i++) {
                if (preorder[i] > flag) {
                    return i;
                }
            }
            return right + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
