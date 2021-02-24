import java.util.HashMap;

/**
 * Description:
 * <p>
 * HashMap
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 将num[i]和其下标映射起来
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        // 遍历nums, 查询target与nums中的元素之差是否存在于map之中
        // 若存在, 则说明有两数之和为target.
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair) && map.get(pair) != i)
                return new int[]{i, map.get(pair)};
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> have = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = have.getOrDefault(target - nums[i], -1);
            if (ind >= 0) return new int[]{ind, i};
            have.put(nums[i], i);
        }
        return null;
    }
}
