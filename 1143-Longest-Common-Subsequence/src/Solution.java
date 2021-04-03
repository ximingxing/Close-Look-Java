/**
 * Description:
 * <p>
 * 动态规划: 递归 + 备忘录
 * <p>
 * Created By xxm
 */
public class Solution {
    int[][] memo;

    private int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) return 0;

        // 现在memo中查看是否计算过
        if (memo[i][j] != 0) return memo[i][j];

        // 当 s1.charAt(i) == s2.charAt(j) 时
        // 当前 i 为 lcs 中的一个,
        // 递归将子串长度扩大
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] != s2[j]意味着,
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(
                    // s1[i] 不在 lcs 中
                    dp(s1, i + 1, s2, j),
                    // s2[i] 不在 lcs 中
                    dp(s1, i, s2, j + 1)
            );
        }

        return memo[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        return dp(text1, 0, text2, 0);
    }
}
