/**
 * Description:
 * <p>
 * 动态规划: 自底向上
 * 可以定义 dp[i][j] 表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列.
 * 状态转移方程:
 * 当 s1[i] == s2[j], dp[i][j] = 1 + dp[i - 1][j - 1];
 * 当 s1[i] != s2[j], dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 * <p>
 * Created By xxm
 */
public class Solution2 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            char s1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char s2 = text2.charAt(j - 1);
                if (s1 == s2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(new Solution2().longestCommonSubsequence(s1, s2));
    }
}
