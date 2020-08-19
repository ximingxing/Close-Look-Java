import java.util.HashMap;

/**
 * Description:
 * <p>
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * <p>
 * Created By xxm
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map element to idx
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        // match pair in nums
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair) && map.get(pair) != i)
                return new int[]{i, map.get(pair)};
        }
        return null;
    }
}
