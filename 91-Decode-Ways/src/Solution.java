/**
 * Description: 动态规划
 * Created By xxm
 */
public class Solution {
    public int numDecodings(String s) {
        final int N = s.length();

        // dp数组定义: 字符串s的前i个字符s[1..i]的解码方法数
        int[] dp = new int[N + 1];
        // base case:
        // 空字符串只能有一种解码方法.
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            // 仅使用一个字符解码, 如果s[i]不为0;
            // 即可被解码为[A..I]. (对应编码数字[0..9])
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // 使用两个字符组合解码, 如果s[i]和s[i-1]不为0;
            // 并且s[i]和s[i-1]组成的整数小于26,
            // 即可被解码为[J..Z].
            if (i > 1 && s.charAt(i - 2) != '0' && (
                    (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("226"));
    }
}
