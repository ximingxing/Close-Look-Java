/**
 * Description:
 * <p>
 * 循环不变量
 * <p>
 * Created By xxm
 */
public class Solution {
    public void sortColors(int[] nums) {
        // [0, i)均为0,
        // [i, j)均为1,
        // [k+1, nums.length-1)均为2
        for (int i = 0, j = 0, k = nums.length - 1; j <= k; ++j) {
            if (nums[j] == 0) {
                // 将i和j交换
                nums[j] = nums[i];
                nums[i++] = 0;
            } else if (nums[j] == 2) {
                // 将j和k交换
                nums[j--] = nums[k];
                nums[k--] = 2;
            }
        }
    }
}
