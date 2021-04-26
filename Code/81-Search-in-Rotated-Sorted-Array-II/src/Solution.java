/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }
}
