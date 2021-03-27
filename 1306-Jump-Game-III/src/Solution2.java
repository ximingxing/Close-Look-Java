import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * 我们可以使用广度优先搜索的方法得到从 start 开始能够到达的所有位置，
 * 如果其中某个位置对应的元素值为 0，那么就返回 True。
 * 具体地，我们初始时将 start 加入队列。
 * 在每一次的搜索过程中，
 * 我们取出队首的节点 u，它可以到达的位置为 u + arr[u] 和 u - arr[u]。
 * 如果某个位置落在数组的下标范围 [0, len(arr)) 内，
 * 并且没有被搜索过，则将该位置加入队尾。
 * 只要我们搜索到一个对应元素值为 0 的位置，我们就返回 True。
 * 在搜索结束后，如果仍然没有找到符合要求的位置，我们就返回 False
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public boolean canReach(int[] arr, int start) {
        // 如果起始位置元素值为0
        if (arr[start] == 0) return true;

        final int n = arr.length;

        // BFS, 利用一个队列
        Queue<Integer> q = new LinkedList<>();
        // 标记搜索过的位置
        boolean[] used = new boolean[n];

        // 起始状态: 将start入队
        q.add(start);
        used[start] = true;

        while (!q.isEmpty()) {
            // 从u开始搜索
            final int u = q.poll();
            // 向 u + arr[u] 和 u - arr[u] 两个方向搜索
            for (int i = 0; i < 2; i++) {
                int cur = u + (i == 0 ? arr[u] : -arr[u]);
                // 如果cur符合规范
                if (cur >= 0 && cur < n) {
                    // 搜索到了
                    if (arr[cur] == 0) return true;
                    // 否则将cur入队
                    if (!used[cur]) {
                        q.add(cur);
                        used[cur] = true;
                    }
                }
            }
        }
        // 搜索全部结果后无解
        return false;
    }
}
