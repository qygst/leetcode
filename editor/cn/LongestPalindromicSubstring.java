//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5172 👎 0


package leetcode.editor.cn;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
        String str = "xaabacxcabaaxcabaax";
        String target = solution.longestPalindrome(str);
        System.out.println(target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) return s;
            // dp[i][j]为true表示 s(i..j)是回文子串
            // dp[i][j] = dp[i+1][j-1] && (s[i] == s[j])
            // 目标值是 dp[i][j]为true时的i-j+1的最大值

            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int maxlen = 1;
            String targe = s.substring(0, 1);

            // 单个字符为回文子串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            for (int L = 2; L <= len; L++) {
                for (int i = 0; i < len; i++) {
                    int j = L + i - 1;

                    if (j >= len) {
                        break;
                    }

                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    if (dp[i][j] && j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        targe = s.substring(i, j + 1);
                    }

                }
            }

            return targe;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}