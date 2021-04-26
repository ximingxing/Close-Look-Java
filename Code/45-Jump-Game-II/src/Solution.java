/**
 * Description: 跳跃游戏(Jump Game) -- Greedy.md
 * Solution: Greedy
 * Created By xxm
 */
public class Solution {
    public int jump(int[] nums) {
        final int N = nums.length;
        // 到达数组最后位置最少跳跃次数
        int minStep = 0;
        // 上次跳跃可达范围的右边界
        int end = 0;
        // 当前位置 i 能到达的最远距离
        int farthest = 0;

        for (int i = 0; i < N - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            // 到达上次跳跃能到达的右边界
            if (i == end) {
                minStep++;
                end = farthest;
            }
        }

        return minStep;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(nums));
    }
}
