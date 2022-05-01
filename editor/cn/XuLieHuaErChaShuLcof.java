//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
// 👍 251 👎 0


package leetcode.editor.cn;

//Java：No.剑指 Offer 37 - 序列化二叉树

import java.util.*;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
        // TO TEST

        String data = "1,2,3,null,null,4,5,6,7";
        TreeNode root = solution.deserialize(data);
        String res = solution.serialize(root);
        System.out.println(res);
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
    public class Codec {
        String nullNode = "null";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String bfs = "";

            // BFS, 队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode cur = null;
            while (!queue.isEmpty()) {
                cur = queue.poll();

                if (cur != null) {
                    bfs += cur.val + ",";

                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    bfs += nullNode + ",";
                }

            }
            while (bfs.endsWith(nullNode + ",") && !bfs.isEmpty()) {
                bfs = bfs.substring(0, bfs.length() - 5);
            }
            return bfs.endsWith(",") ? bfs.substring(0, bfs.length() - 1) : bfs;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<String> dataList = new ArrayList<>(Arrays.asList(data.split(",")));
            return rdeserialize(dataList);
        }

        public TreeNode rdeserialize(List<String> data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            //只有叶子节点的null，才在数组中
            List<TreeNode> dataNode = new ArrayList<>(data.size());
            for (String val : data) {
                if (val.equals(nullNode) || val.isEmpty()) {
                    dataNode.add(null);
                } else {
                    dataNode.add(new TreeNode(Integer.valueOf(val)));
                }
            }

            int parentIndex = 0;
            int childIndex = 1;

            while (childIndex < data.size()) {
                TreeNode parent = dataNode.get(parentIndex++);
                if (parent != null) {
                    parent.left = dataNode.get(childIndex++);
                    if (childIndex < data.size()) {
                        parent.right = dataNode.get(childIndex++);
                    }
                }

            }

            return dataNode.get(0);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
