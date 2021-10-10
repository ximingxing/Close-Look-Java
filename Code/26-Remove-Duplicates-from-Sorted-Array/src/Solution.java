/**
 * Description: 删除数组中的重复元素
 * Solution: Two pointers
 * Created By xxm
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // 双指针 i,j
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // 找到 i,j 指向元素不同的位置
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
