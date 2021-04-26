import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * 单调栈
 * Created By xxm
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 使用堆栈存储heights中的元素下标
        // 表示当前最大的元素对应的下标
        // 堆栈内元素下标指向的矩形高度始终单增
        Deque<Integer> stack = new LinkedList<>();
        final int n = heights.length;
        int r = 0;

        for (int i = 0; i < n; ++i) {
            // 如果当前矩形高度低于右边的矩形高度,
            // 说明当前矩形无法扩展宽度(即不能矩形面积无法变大)
            // 则让当前矩形对应元素出栈, 即为矩形右边界
            for (; !stack.isEmpty() && heights[stack.peek()] >= heights[i]; ) {
                int cur = heights[stack.pop()] * (i - (stack.isEmpty() ? -1 : stack.peek()) - 1);
                r = Math.max(r, cur);
            }
            // i入栈, 代表当前的左边界
            stack.push(i);
        }

        // 如果栈里还有元素
        while (!stack.isEmpty()) {
            int cur = heights[stack.pop()] * (n - (stack.isEmpty() ? -1 : stack.peek()) - 1);
            r = Math.max(r, cur);
        }

        return r;
    }
}
