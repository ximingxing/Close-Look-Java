/**
 * Description: 跳跃游戏(Jump Game) -- Greedy.md
 * Solution: Greedy
 * Created By xxm
 */
public class Solution {
    public boolean canJump(int[] nums) {
        final int N = nums.length;
        int farthest = 0;

        // 每一步都计算从当前步最远能跳跃的位置`step + nums[step]`,
        // 然后和一个全局最优位置`farthest`做对比,
        // 通过每一步的最优解, 更新全局最优解.
        for (int step = 0; step < N - 1; step++) {
            farthest = Math.max(farthest, step + nums[step]);
            if (farthest <= step) return false;
        }

        return farthest >= (N - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }
}
