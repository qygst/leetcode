//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 双指针 👍 3471 👎 0


package leetcode.editor.cn;

//Java：盛最多水的容器
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        // TO TEST

        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int area = solution.maxArea(height);
        System.out.println(area);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            //双指针法，左右指针移动高小的那边，保留高度较高的边以使盛水更多

            int i = 0, j = height.length - 1;
            int area = 0;

            while (i < j) {
                int tmp = calArea(height, i, j);
                area = area > tmp ? area : tmp;
                if (height[i] <= height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
            return area;
        }

        private int calArea(int[] height, int i, int j) {
            return (j - i) * (height[i] < height[j] ? height[i] : height[j]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}