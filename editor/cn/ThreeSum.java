/*
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2635 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println("");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3) return null;

        quickSort(nums, 0, nums.length-1);
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, String> str = new HashMap<>();
        for (int index = 0; index < nums.length && nums[index] <= 0; index++) {
            int target = -nums[index];
            for (int i = index + 1, j = nums.length -1; i < j;) {
                if (nums[i] + nums[j] == target) {
                    str.put(nums[index]+","+nums[i]+","+nums[j],"");
                    i++;
                } else if (nums[i] + nums[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        for (Map.Entry<String, String> entry : str.entrySet()) {
            String tmp = entry.getKey();
            Arrays.asList(tmp.split(","));
            res.add();
        }
        return res;
    }
    private void quickSort(int[] nums, int low, int high) {
            if (low > high) return;

            int i = low;
            int j = high;
            int temp = nums[low];

            while (i < j) {
                //找到比基准小的
                while (nums[j] >= temp && i < j) {
                    j--;
                }
                //找到比基准大的
                while (nums[i] <= temp && i < j) {
                    i++;
                }
                swap(nums, i, j);
            }
            swap(nums, low, i);
            quickSort(nums, low, j - 1);
            quickSort(nums, j + 1, high);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
*/
