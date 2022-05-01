//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 382 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：供暖器
public class Heaters {
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
        // TO TEST
        int[] houses = new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] heaters = new int[]{16531729, 74243042, 114807987, 115438165, 137522503, 143542612, 441282327, 784484492, 823378840, 823564440};

        int res = solution.findRadius(houses, heaters);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1. 每个房子取离他最近的加热器距离为它的半径 （可先排序再二分）
        //2. 取所有房子中最大的半径
        public int findRadius(int[] houses, int[] heaters) {
            int r = 0x80000000;
            Arrays.sort(heaters);

            for (int i = 0; i < houses.length; i++) {
                int h = houses[i];
                int latestH = find(heaters, h);
                if (latestH == h) {
                    if (r == 0x80000000) r = 0;
                    continue;
                }
                int distance = distance(latestH, h);
                System.out.println("house->" + h + ", latestHeater->" + latestH + ", distance ->" + distance);
                r = r > distance ? r : distance;
            }
            return r;

        }

        //在nums中找到里target最近的数字
        private int find(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right && right - left > 1) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return nums[mid];
                else if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            int leftDistance = distance(target, nums[left]);
            int rightDistance = distance(target, nums[right]);
            if (leftDistance < rightDistance) {
                return nums[left];
            } else {
                return nums[right];
            }
        }

        private int distance(int a, int b) {
            return a > b ? a - b : b - a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}