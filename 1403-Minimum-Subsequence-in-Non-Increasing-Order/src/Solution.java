import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 简单贪心
 * Created By xxm
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        if (nums.length == 0) return null;

        // 给数组排序
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        List<Integer> ans = new LinkedList<>();
        // 贪心: 每次选取最大的元素
        for (int i = nums.length - 1, cur = 0; sum - cur >= cur; i--) {
            cur += nums[i];
            ans.add(nums[i]);
        }
        return ans;
    }
}
