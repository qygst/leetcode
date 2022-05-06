//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 👍 2957 👎 0


package leetcode.editor.cn;

//Java：正则表达式匹配
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        // TO TEST
        String s = "aa";
        String p = "a*";
        boolean res = solution.isMatch(s, p);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {

            /**
             * if p[j] 是字母,dp[i][j] = dp[i-1][j-1]
             * if p[j] 是 . dp[i][j] = dp[i-1][j-1]
             * if p[j] 是 *
             *      匹配0次p[j-1], dp[i][j] = dp[i][j-2]
             *      匹配n次p[j-1], dp[i][j] = dp[i-1][j]
             *
             *      总之，s[i]!=p[j-1] dp[i][j] = dp[i][j-2]    把p[j-1]*匹配0次，给消掉
             *            s[i]==p[j-1] dp[i][j] = dp[i-1][j]
             *
             */

            int m = s.length(), n = p.length();

            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            for (int i = 0; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // *
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];

                        if (matches(s, p, i, j - 1)) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }

                    } else {
                        if (matches(s, p, i, j)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
            return dp[m][n];
        }

        private boolean matches(String s, String p, int i, int j) {
            if (i == 0) return false;

            if (p.charAt(j - 1) == '.') return true;
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}