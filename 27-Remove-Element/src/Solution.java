import java.util.ArrayList;

/**
 * Description:
 * <p>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5,
 * with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Created By xxm
 */
public class Solution {
    // two-points
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
