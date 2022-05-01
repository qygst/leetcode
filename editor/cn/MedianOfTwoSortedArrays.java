//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4484 👎 0


package leetcode.editor.cn;

//Java：寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        int[] nums2 = new int[]{2, 4, 5};
        int[] nums1 = new int[]{};
        double mid = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(mid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            return 0.0;
            //二分法
            

            /*//两个数组交叉
            int midVal = median(nums1, nums2, (len1 + len2 + 1) / 2);
            if ((len1 + len2 + 1) / 2 == (len1 + len2 + 2) / 2) return midVal * 1.0;

            int midVa2 = median(nums1, nums2, (len1 + len2 + 2) / 2);
            return (midVal + midVa2) / 2.0;
        }

        private int median(int[] nums1, int[] nums2, int num) {
            int len1 = nums1.length, len2 = nums2.length;
            int cnt1 = 0, cnt2 = 0, eleCount = 0;
            while ((cnt1 < len1 && cnt2 < len2) && eleCount < num - 1) {
                if (nums1[cnt1] <= nums2[cnt2]) {
                    cnt1++;
                } else {
                    cnt2++;
                }
                eleCount++;
            }
            //已确认集合未包含num数据量
            if (eleCount < num) {
                if (cnt1 >= len1) return nums2[num - len1 - 1];
                if (cnt2 >= len2) return nums1[num - len2 - 1];
            }
            //包含num数据量
            return Math.min(nums1[cnt1], nums2[cnt2]);
        }*/
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}
