//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1381 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：最长有效括号
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        String str = ")()())";
        System.out.println(solution.longestValidParentheses(str));
        // TO TEST
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {

            if (s.length() < 2) return 0;

            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            int max = cnt;
            String str = "";

            for (char ch : s.toCharArray()) {
                if ('(' == ch) {
                    stack.push(ch);
                } else if (')' == ch && !stack.isEmpty() && stack.peek().equals('(')) {
                    cnt += 2;
                    max = max < cnt ? cnt : max;
                    str += stack.peek() + ")";
                    stack.pop();
                } else {
                    cnt = 0;
                    str = "";
                    stack.push(ch);
                }
            }
            System.out.println(str);
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
