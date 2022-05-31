//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 830 👎 0


package leetcode.editor.cn;

//Java：整数拆分
public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        // TO TEST
        for (int i = 1; i < 100; i++) {
            System.out.print(i + "--> ");
            System.out.println(solution.integerBreak(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            if (n == 0 || n == 1) return 0;
            if (n <= 3) return n - 1;

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 2;

            for (int i = 4; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    //暂存dp[i], i拆成j, (i-j) 则它们的乘积有两种，(i-j)不拆或拆
//                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                    dp[i] = Math.max(dp[i],  Math.max(j, dp[j]) * Math.max((i-j), dp[i-j]));
                }

            }
            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}