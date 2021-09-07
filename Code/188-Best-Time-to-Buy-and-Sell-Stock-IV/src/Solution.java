/**
 * Description: 买卖K次一只股票获得最大利润
 * Solution:
 * Created By xingximing.xxm
 */
public class Solution {

    // 买卖无限次一只股票获得最大利润
    public int maxProfit(int[] prices) {
        final int N = prices.length;

        int dp_i_0 = 0, dp_i_1 = -prices[0];

        for (int i = 0; i < N; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    public int maxProfit(int maxK, int[] prices) {
        if (prices.length == 0) return 0;

        final int N = prices.length;

        // 由于一次交易由买入和卖出构成，至少需要两天
        // 如果 k > n/2，那么 k = inf
        if (maxK > N / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[N][maxK + 1][2];

        for (int i = 0; i < N; i++) {
            for (int k = maxK; k >= 1; k--) {
                // base case
                if (i - 1 == -1) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[N - 1][maxK][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(new Solution().maxProfit(2, arr));
    }
}
