/**
 * Description: Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * <p>
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5,
 * with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Created By xxm
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
