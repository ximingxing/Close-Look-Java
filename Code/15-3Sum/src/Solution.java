import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 在一个集合中找到三个数和为零, 答案中不可以包含重复的三元组。
 * Solution: 排序+双指针
 * Created By xingximing.xxm
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();

        // 先对数组进行排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字大于0, 则结果一定大于0
            if (nums[i] > 0) break;
            // 跳过重复元素避免出现重复解
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 双指针搜索:
            // [-1, 0, 1, 2, -1, 4]
            //  |   |            |
            // cur left        right
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一组三数之和为零
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去除重复解
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // 移动指针越过已经访问的解元素
                    left++;
                    right--;
                } else if (sum < 0) { // 如果sum<0, 向较大的数字方向搜索
                    left++;
                } else if (sum > 0) { // 如果sum>0, 向较小的数字方向搜索
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, 4}));
    }
}
