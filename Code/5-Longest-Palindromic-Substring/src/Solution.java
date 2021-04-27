/**
 * Description: 最长回文子串
 * Solution: 动态规划: 一个回文去掉两头, 剩下部分依然是回文.
 * Created By xxm
 */
public class Solution {
    public String longestPalindrome(String s) {
        final int N = s.length();
        if (N < 2) return s;

        // dp数组定义: 子串 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[N][N];
        // base case: 长度为 1 的子串是回文串
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        int begin = 0; // 用于记录最长回文串的起始位置
        int maxLen = 1; // 用于纪律最长回文串的长度

        // 按列先填表
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                }
                // 等式一: s.charAt(i) == s.charAt(j)
                // 情况1: 等式一 && dp[i + 1][j - 1]
                // 情况2: 等式一 && j - i < 3, 即 a, aa, 不需要去 dp 中查表
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i < 3)) {
                    dp[i][j] = true;
                }

                // 只要 dp[i][j] 成立, 即 s[i..j] 是回文串;
                // 记录回文串的长度和起始位置.
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}
