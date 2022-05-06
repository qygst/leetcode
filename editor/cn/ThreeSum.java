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
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0, 0};
        int[] nums = new int[]{1, -1, -1, 0};
        List<List<Integer>> res = solution.threeSum(nums);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //难点是去除重复解
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return new ArrayList<>();

            //先排序，再双指针
            quickSort(nums, 0, nums.length - 1);

            List<List<Integer>> res = new ArrayList<>();
            if (nums[0] > 0) return res;

            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) return res;

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return res;
        }


        //二分查找法
        private boolean findInArray(int[] nums, int left, int right, int target) {
            if (left > right || left >= nums.length || right >= nums.length) return false;
            if (nums[left] > target) return false;
            if (nums[right] < target) return false;

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;
            else if (nums[mid] < target) return findInArray(nums, mid + 1, right, target);
            else return findInArray(nums, left, mid - 1, target);
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
