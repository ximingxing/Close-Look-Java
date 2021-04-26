import java.util.Arrays;

/**
 * Description:
 * <p>
 * 回溯算法:
 * K 个子集遍历全部数字, 选择是否将当前遍历到的数字撞进自己这个子集中.
 * <p>
 * Created By xxm
 */
public class Solution2 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 判断不合法
        if (k > nums.length) return false;
        // nums 中元素和无法整除 k
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        // 理论上每个子集的和
        int target = sum / k;
        // 标记 nums 中已经放入子集的数字
        boolean[] used = new boolean[nums.length];

        return backtrack(nums, 0, used, k, 0, target);
    }

    private boolean backtrack(int[] nums, int start, boolean[] used, int k, int capacity, int target) {
        // 全部子集都选择了数字
        if (k == 0) {
            return true;
        }
        // 当前子集选择数字完毕, 递归的让下一个子集从 nums[0] 开始选择
        if (capacity == target) {
            return backtrack(nums, 0, used, k - 1, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            // 排除不合法选择
            if (used[i]) {
                continue;
            }
            if (capacity + nums[i] > target) {
                continue;
            }
            // 选择
            capacity += nums[i];
            used[i] = true;
            // 递归的穷举下一个数字是否加入当前子集
            if (backtrack(nums, i + 1, used, k, capacity, target)) {
                return true;
            }
            // 撤销
            capacity -= nums[i];
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 3, 4, 5};
//        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(new Solution2().canPartitionKSubsets(nums, 4));
    }
}
