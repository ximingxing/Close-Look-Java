
/**
 * Description: 编辑距离
 * Solution: 动态规划
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

        // 如果 word1 或者 word2 其中某个为空串
        if (m * n == 0) return m + n;

        // dp数组含义:
        // word1 的前 i 个字符变为 word2 的前 j 个字符的编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // base case：
        // 一个空串变为非空串需要的编辑距离
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 如果 word1 和 word2 最后一个字符相同
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果不同，则计算"插入"、"删除"、"替换"三种方式中最少的编辑距离
                    // 1. word2 最后一个字符插入 word1 尾部
                    // 2. 删除 word1 最后一个字符
                    // 3. 将 word1 和 word2 最后一个字符替换
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        System.out.println(new Solution2().minDistance(s1, s2));
    }
}
