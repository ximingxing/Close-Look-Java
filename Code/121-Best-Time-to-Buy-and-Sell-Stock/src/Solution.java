/**
 * Description: 买卖一次一只股票获得最大利润
 * Solution: 一次遍历
 * Created By xingximing.xxm
 */
public class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4}; // 5
        System.out.println(new Solution().maxProfit(arr));
    }
}
