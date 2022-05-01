//给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。 
//
// 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。 
//
// 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。 
//
// 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。 
//
// 
//
// 示例 1： 
//
// 输入：s = "ababa"
//输出：1
//解释：字符串本身就是回文序列，只需要删除一次。
// 
//
// 示例 2： 
//
// 输入：s = "abb"
//输出：2
//解释："abb" -> "bb" -> "". 
//先删除回文子序列 "a"，然后再删除 "bb"。
// 
//
// 示例 3： 
//
// 输入：s = "baabb"
//输出：2
//解释："baabb" -> "b" -> "". 
//先删除回文子序列 "baab"，然后再删除 "b"。
// 
//
// 示例 4： 
//
// 输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// s 仅包含字母 'a' 和 'b' 
// 
// Related Topics 双指针 字符串 
// 👍 63 👎 0


package leetcode.editor.cn;

//Java：删除回文子序列
public class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        Solution solution = new RemovePalindromicSubsequences().new Solution();
        // TO TEST
        String s = "abba";
        int cnt = solution.removePalindromeSub(s);
        System.out.println(cnt);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 最多两次，先全删除a，再全删除b
         *
         * @param s
         * @return
         */
        public int removePalindromeSub(String s) {
            if (s == null || s.isEmpty()) return 0;
//            if (isPalindrome(s)) return 1;
            if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
            else return 2;

        }

        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] != chars[s.length()-1-i]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
