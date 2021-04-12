import java.util.Arrays;

/**
 * Description:
 * <p>
 * 动态规划
 * <p>
 * Created By xxm
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length, n = envelopes[0].length;

        // 对二维数组排序: 第一列升序排列;
        // 当第一列相同时, 第二列降序排列.
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });

        // 寻找二维信封嵌套问题转化为:
        // 寻找第二列元素最长递增子序列的长度.
        int[] heights = new int[m];
        for (int i = 0; i < m; i++) {
            heights[i] = envelopes[i][1];
        }

        // 第二列元素最长递增子序列的长度为1.
        return lengthOfLIS(heights);
    }

    /* 求最长递增子序列的长度 (leetcode #300题)*/
    private int lengthOfLIS(int[] heights) {
        final int N = heights.length;

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (heights[j] < heights[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        System.out.println(new Solution().maxEnvelopes(envelopes));
    }
}
