import java.util.Arrays;

/**
 * Description:
 * <p>
 * 自底向上的动态规划
 * <p>
 * Created By xxm
 */
public class Solution2 {
    // 求三个数中的最小值
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    /* 计算字符串 s1 变为 s2 的最小编辑距离 */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化 dp table
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移方程:
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        System.out.println(new Solution2().minDistance(s1, s2));
    }
}
