/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) return nums[0];

        int curSum = nums[0];
        int output = curSum;
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            output = Math.max(curSum, output);
        }
        return output;
    }
}
