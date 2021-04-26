/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            else {
                if (i == (nums.length - 1)) return nums.length; // target bigger than all nums`s element.
                if (nums[i] < target && nums[i + 1] > target) return i + 1; // find position to insert.
            }
        }
        return 0;   // not found.
    }
}
