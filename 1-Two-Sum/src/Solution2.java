import java.util.HashMap;

/**
 * Description:
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map idx to element
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        //
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair) && map.get(pair) != i)
                return new int[]{i, map.get(pair)};
        }
        return null;
    }
}
