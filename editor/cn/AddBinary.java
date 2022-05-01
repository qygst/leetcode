//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 506 👎 0

package leetcode.editor.cn;


public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        String a = "100";
        String b = "110010";
        System.out.println(solution.addBinary(a,b));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int carry = 0;
        String sum = "";
        int i = 1;
        for ( ; i <= b.length(); i++) {
             int numa = (int)a.charAt(a.length() - i) - (int)'0';
            int numb = (int)b.charAt(b.length() - i) - (int)'0';
            sum = (numa + numb + carry) % 2 + sum;
            carry = (numa + numb + carry) / 2;
        }
        while (i <= a.length()) {
            int numa = (int)a.charAt(a.length() - i++) - (int)'0';
            sum = (numa + carry) % 2 + sum;
            carry = (numa + carry) / 2;
        }

        return carry == 0? sum : carry + sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
