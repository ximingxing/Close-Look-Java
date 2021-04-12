import java.util.Arrays;

/**
 * Description:
 * <p>
 * 动态规划
 * 时间复杂度: O(N^2)
 * <p>
 * Created By xxm
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        final int N = nums.length;
        // dp数组
        // `dp[i]`表示以`nums[i]`这个数结尾的最长递增子序列的长度.
        int[] dp = new int[N];
        // 将dp数组全部初始化为 1, 因为子序列最少也要包含自己
        // 所以最少长度为 1.
        Arrays.fill(dp, 1);

        // 计算dp数组
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 如果序列保持递增
                if (nums[j] < nums[i])
                    // 状态转移方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 遍历dp数组中最大的值, 即为最长递增子序列的长度
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(arr));
    }
}
