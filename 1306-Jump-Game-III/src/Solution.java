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
public class Solution {
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
            // 我们取出队首的节点 u
            int u = q.poll();
            // 它可以到达的位置为 u + arr[u]
            if (u + arr[u] < n && !used[u + arr[u]]) {
                // 搜索到了
                if (arr[u + arr[u]] == 0) return true;
                // 否则, 入队, 成为新的队头
                q.add(u + arr[u]);
                used[u + arr[u]] = true;
            }

            // 它可以到达的位置为 u - arr[u]
            if (u - arr[u] >= 0 && !used[u - arr[u]]) {
                // 搜索到了
                if (arr[u - arr[u]] == 0) return true;
                // 否则, 入队
                q.add(u - arr[u]);
                used[u - arr[u]] = true;
            }
        }
        // 搜索全部结果后无解
        return false;
    }
}
