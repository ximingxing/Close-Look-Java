import java.util.Arrays;

/**
 * Description: 区间调度问题(Interval Scheduling) -- Greedy.md
 * 解法: 贪心算法
 * Created By xxm
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        // 将所有区间按照区间结束(end)位置排序
        // 这里不能直接返回 a[1] - b[1],
        // 因为会测试用例 `[[-2147483646,-2147483645],[2147483646,2147483647]]`
        // 会导致溢出.
        Arrays.sort(points, (int[] a, int[] b) -> {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else {
                return 0;
            }
        });

        // 统计最多不相交区间的个数
        // 至少有一个区间不与其他区间相交
        int count = 1;
        int x_end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            // 题目条件: 满足 x_start ≤ x ≤ x_end 则气球会被引爆;
            if (start > x_end) {
                count++;
                x_end = points[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(new Solution().findMinArrowShots(points));
    }
}
