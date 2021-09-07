/**
 * Description: 买卖多次一只股票获得最大利润，但每次卖出之后需要支付手续费.
 * Solution: 状态机
 * Created By xingximing.xxm
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        final int N = prices.length;

        int dp_i_0 = 0, dp_i_1 = -prices[0];

        for (int i = 0; i < N; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(new Solution().maxProfit(arr, 2));
    }
}
