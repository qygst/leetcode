//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 649 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：数据流的中位数
public class FindMedianFromDataStream {
    public static void main(String[] args) {
//        Solution solution = new FindMedianFromDataStream().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        private PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> b - a);
            right = new PriorityQueue<>((a, b) -> a - b);
        }

        /**
         * 左边为大顶堆，右边为小顶堆，左边的值 < 右边的值
         * 如果为奇数，左边数量多一
         * 如果为偶数，两边数量相等
         * @param num
         */
        public void addNum(int num) {

            if (left.isEmpty() || num < left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (left.size() > right.size() + 1) {
                //左边比右边多两个，则左减一右加一
                right.offer(left.poll());
            } else if (left.size() < right.size()) {
                //右边比左边多一个，往左移一个
                left.offer(right.poll());
            }

        }

        public double findMedian() {
            if (left.size() > right.size()) return left.peek();
            return (left.peek() + right.peek()) / 2.0;

        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}