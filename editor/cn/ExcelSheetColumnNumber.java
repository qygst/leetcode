//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
//
// 例如：
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
// 示例 1:
//
//
//输入: columnTitle = "A"
//输出: 1
//
//
// 示例 2:
//
//
//输入: columnTitle = "AB"
//输出: 28
//
//
// 示例 3:
//
//
//输入: columnTitle = "ZY"
//输出: 701
//
//
//
// 提示：
//
//
// 1 <= columnTitle.length <= 7
// columnTitle 仅由大写英文组成
// columnTitle 在范围 ["A", "FXSHRXW"] 内
//
//
// Related Topics 数学 字符串 👍 348 👎 0


package leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

//Java：Excel 表列序号
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
        // TO TEST
        String columnTitle = "AB";
        System.out.println(solution.titleToNumber(columnTitle));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            if (columnTitle == null || columnTitle.isEmpty()) return 0;
            int len = columnTitle.length();
            int num = 0;
            for (int i = len - 1; i >= 0; i--) {
                num += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}