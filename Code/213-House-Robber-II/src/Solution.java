import java.util.Arrays;

/**
 * Description:
 * <p>
 * 动态规划
 * <p>
 * Created By xxm
 */
public class Solution {
    private int myRob(int[] nums, int start, int end) {
        int len = end - start;
        // dp数组
        // dp[i]定义: 前i个房屋能偷窃的最大值
        int[] dp = new int[len + 1];

        // base case
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        // 状态转移方程: 是否偷窃第 i 号房屋;
        // 要比较 i-2 号房屋的最大值加上当前房屋的金额,
        // 与 i-1 号房屋的最大金额; 取最大值.
        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(
                    dp[i - start - 1],
                    nums[i] + dp[i - start - 2]
            );
        }

//        System.out.println("dp: " + Arrays.toString(dp));

        return dp[len];
    }

    public int rob(int[] nums) {
        // 如果只有一间房屋, 则返回这间房屋的可偷窃金额
        if (nums.length == 1) {
            return nums[0];
        }
        // 如果有两间房屋, 则返回两件中金额最大的
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 因为首个房屋和最后一个房屋相连,
        // 所以第一个房屋和最后一个房屋不能同时抢;
        return Math.max(
                myRob(nums, 0, nums.length - 2),
                myRob(nums, 1, nums.length - 1)
        );
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 1};
        int[] arr = new int[]{1, 7, 9, 2};
        System.out.println(new Solution().rob(arr));
    }
}
