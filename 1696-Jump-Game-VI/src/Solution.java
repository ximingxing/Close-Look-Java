import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 思路: 这个题目可以看作滑动窗口内的最大值.
 * 解法: 单调队列
 * <p>
 * Created By xxm
 */
public class Solution {
    public int maxResult(int[] nums, int k) {
        // 单调队列, 存储下标
        Deque<Integer> q = new LinkedList<>();
        final int n = nums.length;

        // 循环遍历nums, last用于保存上一个滑动窗口中的最大值
        for (int i = 0, last = 0; i < n; ++i) {
            // 如果窗口内的元素个数超过窗口大小, 出队
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            // 如果当前第i个元素的值大于单调队列中最后一个元素,
            // 则让队尾元素出队;
            // 循环这个过程, 单调队列中的所有元素满足单调性.
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.removeLast();
            }
            // 当前第i个元素满足单调性
            q.add(i);
            // 第i个元素最大值 == 当前第i个元素的值 + 前i个元素可以组合成的最大值
            nums[i] += last;
            // 更新last, 为下一个滑动窗口作准备.
            last = nums[q.peek()];
        }
        // 返回数组中最后一个元素即可.
        return nums[nums.length - 1];
    }
}
