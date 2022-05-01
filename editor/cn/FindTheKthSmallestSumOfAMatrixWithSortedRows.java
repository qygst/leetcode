//给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。 
//
// 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。 
//
// 
//
// 示例 1： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 5
//输出：7
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。  
//
// 示例 2： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 9
//输出：17
// 
//
// 示例 3： 
//
// 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
//输出：9
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。 
// 
//
// 示例 4： 
//
// 输入：mat = [[1,1,10],[2,2,9]], k = 7
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat.length[i] 
// 1 <= m, n <= 40 
// 1 <= k <= min(200, n ^ m) 
// 1 <= mat[i][j] <= 5000 
// mat[i] 是一个非递减数组 
// 
// Related Topics 数组 二分查找 矩阵 堆（优先队列） 👍 89 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

//Java：有序矩阵中的第 k 个最小数组和
public class FindTheKthSmallestSumOfAMatrixWithSortedRows {
    public static void main(String[] args) {
        Solution solution = new FindTheKthSmallestSumOfAMatrixWithSortedRows().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Info implements Comparable<Info> {
            int currentSum;
            List<Integer> pointers;

            Info(int currentSum, List<Integer> pointers) {
                this.currentSum = currentSum;
                this.pointers = pointers;
            }

            @Override
            public String toString() {
                return this.currentSum + "," + this.pointers;
            }

            @Override
            public int compareTo(Info other) {//从小到大排序
                return this.currentSum - other.currentSum;
            }

        }

        public int kthSmallest(int[][] mat, int k) {

            int m = mat.length, n = mat[0].length;
            PriorityQueue<Info> queue = new PriorityQueue<Info>();
            Set<List<Integer>> seen = new HashSet<>();
            int currentSum = 0;
            List<Integer> pointers = new ArrayList<>();// 用int[]， contains识别不出来
            for (int i = 0; i < m; ++i) {
                currentSum += mat[i][0];
                pointers.add(0);

            }
            queue.offer(new Info(currentSum, pointers));
            seen.add(pointers);
            for (int i = 0; i < k; ++i) {
                Info info = queue.poll();
                currentSum = info.currentSum;
                pointers = info.pointers;
                //每个指针轮流向后移动1个
                for (int row = 0; row < m; ++row) {
                    List<Integer> newpointers = new ArrayList<>(pointers);
                    int newsum = currentSum;
                    int col = pointers.get(row);
                    if (col < n - 1) {
                        newpointers.set(row, col + 1);
                        if (!seen.contains(newpointers)) {
                            newsum += -mat[row][col] + mat[row][col + 1];
                            queue.offer(new Info(newsum, newpointers));
                            seen.add(newpointers);
                        }
                    }
                }

            }

            return currentSum;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}