import java.util.Arrays;

/**
 * Description:
 * Created By xxm
 */
public class Solution2 {
    public int videoStitching(int[][] clips, int T) {
        // 将片段按照起点升序排序, 如果起点相同则按照降序排序
        Arrays.sort(clips, (int[] a, int[] b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        // 统计最少片段个数
        int num = 0;
        // 当前片段结尾, 下一个片段结尾
        int end = 0, nextEnd = 0;

        int i = 0, n = clips.length;
        // 遍历所有片段
        while (i < n && clips[i][0] <= end) {
            // 在起点小于 end 的片段中贪心的选择最长的片段
            while (i < n && clips[i][0] <= end) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            // 找到下一个片段
            num++;
            // 更新 end
            end = nextEnd;
            // 已经可以拼凑出包含 [0, T] 的视频
            if (end >= T) {
                return num;
            }
        }
        // 无法拼凑出包含 [0, T] 的视频
        return -1;
    }

    public static void main(String[] args) {
        int[][] clips1 = new int[][]{
                {0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}
        };
        System.out.println(new Solution2().videoStitching(clips1, 10));

        int[][] clips2 = new int[][]{{0, 1}, {1, 2}};
        System.out.println(new Solution2().videoStitching(clips2, 5));

        int[][] clips3 = new int[][]{{0, 4}, {2, 8}};
        System.out.println(new Solution2().videoStitching(clips3, 5));
    }
}
