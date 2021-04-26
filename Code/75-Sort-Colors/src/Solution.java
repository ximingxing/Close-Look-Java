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
                // 将i和j交换;
                // 这里nums[i]已经遍历过, 所以不需要i++
                nums[j] = nums[i];
                // 扩大 0 区
                nums[i++] = 0;
            } else if (nums[j] == 2) {
                // 将j和k交换;
                // 在将nums[j]与nums[k]交换后, nums[k]原本指向的元素还未遍历过, 所以需要j--
                nums[j--] = nums[k];
                // 扩大 2 区
                nums[k--] = 2;
            }
        }
    }
}
