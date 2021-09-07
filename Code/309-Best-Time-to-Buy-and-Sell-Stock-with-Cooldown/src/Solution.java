/**
 * Description: 买卖多次一只股票获得最大利润，但每次卖出之后需要停止交易一天.
 * Solution: 状态机
 * Created By xingximing.xxm
 */
public class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;

        int dp_i_0 = 0, dp_i_1 = -prices[0];
        int dp_pre_0 = 0; // 代表 dp[i-2][0]

        for (int i = 0; i < N; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            // dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
            // 解释：第 i 天选择 `buy` 的时候，要从 i-2 的状态转移，而不是 i-1 。
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 0, 2};
        System.out.println(new Solution().maxProfit(arr));
    }
}
