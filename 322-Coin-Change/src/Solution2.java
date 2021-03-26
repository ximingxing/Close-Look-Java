import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * <p>
 * 动态规划
 * <p>
 * Created By xxm
 */
public class Solution2 {

    public static int coinChange(int[] coins, int amount) {
        // 凑成 amount 金额的硬币数最多只可能等于 amount (全用 1 元面值的硬币),
        // 所以初始化为 amount + 1 就相当于初始化为正无穷, 便于后续取最小值.
        int max = amount + 1;
        // dp数组记录转移状态
        int[] dp = new int[max];
        // 为dp数组中的每个元素赋初始值`amount + 1`
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 遍历dp的全部状态
        for (int i = 1; i <= amount; i++) {
            // 求解所有选择的最小值
            for (int coin : coins) {
                // 子问题无解, 跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == max) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int res = coinChange(coins, 11);
        System.out.println(res);
    }
}
