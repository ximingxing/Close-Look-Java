/**
 * Description:
 * <p>
 * 动态规划
 * <p>
 * Created By xxm
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // dp数组: 以 nums[i] 为结尾的「最大子数组和」为 dp[i]
        int[] dp = new int[nums.length];

        // base case
        dp[0] = nums[0];

        // 状态转移方程
        for (int i = 1; i < nums.length; i++) {
            // 这里要确保是连续子数组
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // 找出dp数组中的最大值即为最大和
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
