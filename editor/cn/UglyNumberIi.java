//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 850 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：丑数 II
public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] factors = new int[]{2, 3, 5};
            PriorityQueue<Long> pq = new PriorityQueue<>();
            pq.offer(1L);
            long ugly = 1L;

            while (n-- > 0) {
                ugly = pq.poll();
                while (!pq.isEmpty() && pq.peek() == ugly) {
                    pq.poll();
                }
                for (long factor : factors) {
                    pq.offer(factor * ugly);
                }
            }
            return (int) ugly;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}