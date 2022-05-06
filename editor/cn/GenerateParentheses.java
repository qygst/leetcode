//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2621 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST

        int n = 3;
        List<String> res = solution.generateParenthesis(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> brackets = new ArrayList<>();

            if (n == 0) return brackets;

            // dfs + 剪枝（要保证左 >= 右）
            dfs(brackets, n, "", n, n);
            return brackets;
        }

        private void dfs(List<String> res, int n, String sb, int left, int right) {
            if (sb.length() == 2 * n) {
                res.add(sb);
                return;
            }

            //剪枝
            if (left > right) return;

            if (left > 0) {
                dfs(res, n, sb + "(", left - 1, right);
            }
            if (right > 0) {
                dfs(res, n, sb + ")", left, right - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}