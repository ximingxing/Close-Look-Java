import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * 递归 + 备忘录
 * <p>
 * Created By xxm
 */
public class Solution {

    /**
     * @param coins 可选的硬币
     * @param rem   当前金额
     * @param count 备忘录
     * @return 为了凑够当前金额需要最少的硬币数量
     */
    private static int coinChange(int[] coins, int rem, int[] count) {
        // base case
        if (rem < 0) return -1;
        if (rem == 0) return 0;

        // 先在备忘录中查找是否存在当前金额
        // 保证每个子问题仅被求解一次
        if (count[rem] != 0) return count[rem];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 递归求解子问题
            int res = coinChange(coins, rem - coin, count);
            // 当前情况下用的硬币个数更少, 更新min
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        // count[rem]存储着给定金额amount的解
        // 若为Integer.MAX_VALUE则该情况无解
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int res = coinChange(coins, 11);
        System.out.println(res);
    }
}
