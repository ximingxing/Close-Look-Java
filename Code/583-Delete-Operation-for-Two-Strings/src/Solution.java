/**
 * Description:
 * <p>
 * 动态规划
 * 思路: 题目让我们计算将两个字符串变得相同的最少删除次数，
 * 那我们可以思考一下，最后这两个字符串会被删成什么样子？
 * 删除的结果不就是它俩的最长公共子序列嘛！
 * <p>
 * Created By xxm
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // dp定义: word1 和 word2 最长公共子序列
        int[][] dp = new int[m + 1][n + 1];

        // base case
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 与leetcode300题求LCS相同.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // 两个字符串变得相同的最少删除次数
        return m - dp[m][n] + n - dp[m][n];
    }
}
