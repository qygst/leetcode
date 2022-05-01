//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 723 👎 0

package leetcode.editor.cn;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = new int[]{1,3,5};
        int target = 3;
        System.out.println(solution.searchInsert(nums, target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            nums = new int[]{target};
            return 0;
        }
        int index = binarySearch(nums, 0, nums.length-1, target);
        return index;

    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        if (nums[left] >= target) return left;
        if (nums[right] < target) return right+1;
        if (nums[right] == target) return right;
        int index = (left + right) / 2;
        while (nums[index] != target) {
            if (nums[index] > target) {
                return binarySearch(nums, left, index-1, target);
            } else if (nums[index] < target) {
                return binarySearch(nums, index+1, right, target);
            } else {
                return index;
            }
        }
        return index;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
