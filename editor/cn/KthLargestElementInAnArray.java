//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 727 👎 0

package leetcode.editor.cn;
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{-1,2,0};
        int res = solution.findKthLargest(nums, 2);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, k, 0, nums.length-1);
        }

        private int quickSelect(int[]  nums, int k, int low, int high) {
            midPartition(nums, low, high);
            int q = partition(nums, low,high);
            if (q+1 == k) {
                return nums[q];
            } else {
                return q+1 < k ? quickSelect(nums, k, q+1, high) : quickSelect(nums, k, low, q-1);

            }
        }
        // 选择快排基准
        private void midPartition(int[] nums, int low, int high) {
            int max = Math.max(nums[(high-low) /2], Math.max(nums[low], nums[high]));
            int min = Math.min(nums[(high-low) /2], Math.min(nums[low], nums[high]));
            if (nums[high] > min && nums[high] < max) {
                swap(nums, low, high);
            } else if (nums[(high-low) /2] > min && nums[(high-low) /2] < max) {
                swap(nums, low, (high - low) / 2);
            }
        }
        //一次快排
        private int partition(int[] nums, int low, int high) {
            int i = low;
            int j = high;
            int tmp = nums[low];

            while (i < j) {
                while (j>i && nums[j] <= tmp) {
                    j--;
                }
                while (i<j && nums[i] >= tmp) {
                    i++;
                }
                swap(nums, i, j);
            }
            swap(nums, low, i);
            return i;
        }
        //交换数组元素
        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
