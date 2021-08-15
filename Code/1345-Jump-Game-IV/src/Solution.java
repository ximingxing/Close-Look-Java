import java.util.*;

/**
 * Description: 跳跃游戏 IV (特点：隐式图, 边长为1；每次仅跳跃一步)
 * Solution: BFS
 * 跳跃到相同的值时，仅第一次到达有意义
 * Created By xingximing.xxm
 */
public class Solution {
    public int minJumps(int[] arr) {
        final int n = arr.length;

        // 使用map存储arr之中的元素以及其对应的下标，由于可能存在相同元素，所以下标使用list存储
        HashMap<Integer, List<Integer>> all = new HashMap<>();
        // steps表示从起点跳跃到当前位置的最小步数（同时标记走过的位置）
        int[] steps = new int[n];

        // 初始化 map 和 steps 数组
        for (int i = 0; i < n; i++) {
            List<Integer> temp = all.getOrDefault(arr[i], new ArrayList<>());
            temp.add(i);
            all.put(arr[i], temp);
            steps[i] = -1; // 表示从未到达过下标i的位置
        }

        // BFS
        // 队列用于存储跳跃过程中经过元素的下标
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        // 从起点下标0开始，一直遍历到最后一个未被访问过的位置
        for (steps[0] = 0; steps[n - 1] < 0; ) {
            int idx = queue.poll();
            // 向左跳跃
            if (idx > 0 && steps[idx - 1] < 0) { // `step[idx - 1] < 0`表示没有经过 idx - 1
                steps[idx - 1] = steps[idx] + 1;
                queue.offer(idx - 1);
            }
            // 向右跳跃
            if (idx + 1 < n && steps[idx + 1] < 0) {
                steps[idx + 1] = steps[idx] + 1;
                queue.offer(idx + 1);
            }
            // 同值跳跃
            if (all.containsKey(arr[idx])) {
                for (int same : all.getOrDefault(arr[idx], new ArrayList<>())) {
                    if (steps[same] < 0) {
                        steps[same] = steps[idx] + 1; // 注意：这里仅跳跃一步
                        queue.offer(same);
                    }
                }
                // 跳跃到相同的值时(除起点外)，仅第一次到达有意义，因为后续到达肯定会走更多的步数
                all.remove(arr[idx]);
            }
        }
        return steps[n - 1];
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
//        int[] arr = new int[]{7};
        int[] arr = new int[]{6, 1, 9};
        System.out.println(new Solution().minJumps(arr));
    }
}
