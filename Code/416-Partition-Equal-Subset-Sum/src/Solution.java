/**
 * Description:
 * <p>
 * 该问题可以转化为0-1背包问题, 即
 * 给定一个可装载重量 sum/2 的背包和 N 个物品, 每个物品重量为nums[i],
 * 是否存在一种装法, 恰好将背包装满.
 * <p>
 * Created By xxm
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        final int N = nums.length;
        if (N <= 1) return false;
        // 对数组中元素求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果 sum 为奇数, 则不可能分成两个子集
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // dp数组: 装入第 i 个物品后的剩余重量是否满足 sum
        boolean[][] dp = new boolean[N + 1][target + 1];

        // base case:
        // 背包重量为 0 时,
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                // 如果剩余容量无法装入第 i 个物品
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果可以装入第 i 个物品;
                    // 装入或者不装背包.
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[N][target];
    }
}
