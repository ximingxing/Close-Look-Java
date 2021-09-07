/**
 * Description: 买卖多次一只股票获得最大利润
 * Solution: 状态机
 * Created By xingximing.xxm
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        final int N = prices.length;

        // base case
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int temp = dp_i_0;
            // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k-1][1] + prices[1])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[1])
            //             = max(dp[i-1][k][1], dp[i-1][k][0] - prices[1])
            // 由于 k = k-1 = inf
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 6};
        System.out.println(new Solution2().maxProfit(arr));
    }
}