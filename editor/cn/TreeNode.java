package leetcode.editor.cn;

/**
 * @author wangbing
 * @date 2020/10/12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createBiTree(Integer[] values) {
        if (values.length == 0) return null;
        //把数组变成树节点数组
        TreeNode[] treeNodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                treeNodes[i] = new TreeNode(values[i]);
            }
        }
        //确定左右子树
        for (int i = 0; i < values.length / 2; i++) {
            if (2 * i + 1 < values.length) {
                treeNodes[i].left = treeNodes[2 * i + 1];
            }
            if (2 * i + 2 < values.length) {
                treeNodes[i].right = treeNodes[2 * i + 2];
            }
        }
        return treeNodes[0];
    }
}
