/**
 * Description: 买卖一次一只股票获得最大利润
 * Solution: 状态机
 * Created By xingximing.xxm
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        final int N = prices.length;

        // dp数组: 第i天，持股或者不持股，获得的最大收益
        int[][] dp = new int[N][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < N; i++) {
            // 今天不持股的收入 = max(前一天不持股今天继续不持股, 前一天卖掉持有的股票)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持股的收入 = max(前一天持股今天继续持股, 前一天买入股票)
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        // 最后一天，不持股，可以获得的最大收益
        return dp[N - 1][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4}; // 5
        System.out.println(new Solution2().maxProfit(arr));
    }
}
