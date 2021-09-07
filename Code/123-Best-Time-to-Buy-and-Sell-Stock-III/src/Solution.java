/**
 * Description: 买卖二次一只股票获得最大利润
 * Solution: 状态机
 * Created By xingximing.xxm
 */
public class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length; // 总天数
        final int maxK = 2; // 买卖股票的次数

        // dp数组
        int[][][] dp = new int[N][3][2];

        // base case
        dp[0][2][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < N; i++) { // 枚举每一天
            for (int k = maxK; k >= 1; k--) { // 枚举两次交易
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态
        return dp[N - 1][maxK][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 5, 0, 0, 3, 1, 4}; // 6
//        int[] arr = new int[]{1, 2, 3, 4, 5}; // 6
        System.out.println(new Solution().maxProfit(arr));
    }
}
