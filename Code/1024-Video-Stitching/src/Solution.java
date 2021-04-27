import java.util.Arrays;

/**
 * Description: 贪心: 选择右端点尽可能大的片段
 * Created By xxm
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        // 将片段按照起点升序排序, 如果起点相同则按照降序排序
        Arrays.sort(clips, (a, b) -> {
            return a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]);
        });
        // num标记最少需要的片段数量; right标记片段右边界
        int num = 0, right = 0;
        // left 标记片段左端点.
        // 贪心: 从片段左端点开始, 选择右端点尽可能大的片段;
        // 每次查找片段结束后让 left = right, 从右端点开始下一轮查找.
        for (int left = 0, i = 0; left < T && i < clips.length; left = right, num++) {
            // 在不大于左边界的片段中, 找右边界最大的片段
            for (; right < T && i < clips.length && clips[i][0] <= left; ) {
                right = Math.max(right, clips[i++][1]);
            }
            // 查找结束后, 左右边界依然相等则说明无法片段无法到达 T 时刻.
            if (left == right) return -1;
        }
        // 最后判断片段是否到达T
        return right >= T ? num : -1;
    }
}
