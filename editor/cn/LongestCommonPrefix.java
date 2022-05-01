//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1318 👎 0

package leetcode.editor.cn;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String com = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (com.isEmpty()) break;
            com = commonPrefix(com, strs[i]);
        }
        return com;
    }

    private String commonPrefix(String s1, String s2) {
        String res = "";
        int i = 0;
        while (i < s1.length() && i<s2.length()) {
            if (!s1.substring(0,i+1).equals(s2.substring(0, i+1))) {
                break;
            }
            ++i;
        }
        if (i==0) return "";
        return s1.substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
