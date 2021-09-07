/**
 * Description: 买卖多次一只股票获得最大利润
 * Solution: 贪心法
 * Created By xingximing.xxm
 */
public class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < N; i++) {
            if (i + 1 < N && prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 6};
        System.out.println(new Solution().maxProfit(arr));
    }
}