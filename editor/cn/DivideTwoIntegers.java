//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 👍 897 👎 0

package leetcode.editor.cn;

//Java：两数相除
public class DivideTwoIntegers {
   /* public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        // TO TEST
        int dividend = -2147483648;
        int divisor = -3;
        System.out.println(solution.divide(dividend, divisor));
        System.out.println(dividend / divisor);
        System.out.println(Math.pow(2, 31));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {

            if (dividend == Integer.MIN_VALUE) {
                if (divisor == 1) return Integer.MIN_VALUE;
                if (divisor == -1) return Integer.MAX_VALUE;
            }
            //把所有正数都取相反数，这样只需考虑一种情况
            boolean rev = false;
            if (dividend > 0) {
                dividend = -dividend;
                rev = !rev;
            }
            if (divisor > 0) {
                divisor = -divisor;
                rev = !rev;
            }

            //二分法，X/Y  Z*Y<= X <= (Z+1)*Y
            //乘积不能使用乘法，可以使用快乘法
            int left = 1, right = Integer.MAX_VALUE, ans = 0;

            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                boolean check = kcf(divisor, mid, dividend);
                if (check) {
                    // 取右区间
                    ans = mid;
                    if (mid == Integer.MAX_VALUE) {
                        break;
                    }
                    left = mid + 1;
                } else {
                    //取左区间
                    right = mid - 1;
                }
            }


        }

        private boolean kcf(int y, int z, int x) {
            // x, y <0, z>0
            // 二分条件要取右区间，要保证 z*y < x
            int ans = 0, base = y;
            while (z != 0) {
                if ((base & 1) != 0) {
                    ans += base;
                    if (ans > x) return false;
                }
                base *= base;
                z >>= 1;
            }
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}