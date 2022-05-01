//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2268 👎 0

package leetcode.editor.cn;
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int x = 1534236469;
        int res = solution.reverse(x);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String numStr = String.valueOf(x);
        if (numStr.length() == 1) return x;
        boolean negative = false;
        if (numStr.charAt(0) == '-') {
            negative = true;
            numStr = numStr.substring(1);
        }
        int res = 0;
        for (int i = numStr.length()-1; i >= 0; i--) {
            int cur = Integer.valueOf(numStr.substring(i, i+1));
            if ((res*10 + cur)/10 != res) return 0;
            res = res*10 + cur;
        }
        return res * (negative?-1:1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
