import java.util.Arrays;

/**
 * Description: 区间调度问题(Interval Scheduling) -- Greedy.md
 * 解法: 贪心算法
 * Created By xxm
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 将所有区间按照结束(end)排序
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[1] - b[1];
        });

        // 统计最多不重叠区间的个数
        int count = 1;
        int x_end = intervals[0][1];

        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }

        // 区间总数 - 最多不重叠区间的个数 = 至少需要去除的区间使得全部区间不重叠
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}
