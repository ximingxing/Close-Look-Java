import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                 最大值
 * ---------------              -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 思路: 单调队列
 * 窗口内的值又老又小没有存在必要.
 * 窗口内越老的值越大.
 * <p>
 * Created By xxm
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 数组长度
        final int n = nums.length;
        // 声明一个双端队列存储下标 (需要维护队列的单调性)
        Deque<Integer> q = new LinkedList<>();
        // 这里返回数组大小为`n-k+1`, 因为前k个元素不满足窗口大小
        int[] res = new int[n - k + 1];

        // 遍历nums数组
        for (int i = 0; i < n; ++i) {
            // 如果队列中内元素太老(窗口内元素个数超过k), 扔掉队首.
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            // 入队时保持队列单调性:
            // 如果当前队尾的元素小于等于第i个元素;
            // 则让队尾出队, 维持单调性.
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.removeLast();
            }
            // 第i个元素具有单调性, 入队
            q.add(i);
            // 只有至少有k个元素时, 才返回最大值(队首元素).
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
    }
}
