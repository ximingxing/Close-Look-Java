import java.util.LinkedList;
import java.util.List;

/**
 * Description: 在一个集合中找到三个数和为零
 * Solution: 回溯
 * Created By xingximing.xxm
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    private void backtrace(int[] nums, LinkedList<Integer> track) {
        // 找到一组合法的三数之和为零
        if ((track.size() == 3) && (track.get(0) + track.get(1) + track.get(2) == 0)) {
            result.add(track);
            return;
        }
        // 寻找所有可能的组合
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrace(nums, track);
            track.removeLast();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        backtrace(nums, new LinkedList<>());
        return result;
    }
}
