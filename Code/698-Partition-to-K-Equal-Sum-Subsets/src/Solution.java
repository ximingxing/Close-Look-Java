import java.util.Arrays;

/**
 * Description:
 * <p>
 * 回溯算法:
 * n 个数字都要选择进入到 k 个子集中的某一个(遍历子集).
 * <p>
 * Created By xxm
 */
public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 判断不合法
        if (k > nums.length) return false;
        // nums 中元素和无法整除 k
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        // 理论上每个子集的和
        int target = sum / k;
        // 分别存储 k 个子集的和
        int[] subSets = new int[k];

        // 优化: 将 nums 由大到小排序
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return backtrack(nums, 0, subSets, target);
    }

    private boolean backtrack(int[] nums, int index, int[] subSets, int target) {
        // 1. 触发结束条件
        if (index == nums.length) {
            // 判断是否合法子集之和是否合法
            for (int subSet : subSets) {
                if (subSet != target) return false;
            }
            // 子集之和合法
            return true;
        }

        // 2. 穷举 nums[index] 放入的子集
        for (int i = 0; i < subSets.length; i++) {
            // 排除不合法的情况: 子集之和大于 target
            if (subSets[i] + nums[index] > target) {
                continue;
            }
            // 选择
            subSets[i] += nums[index];
            // 递归下一个数字选择
            if (backtrack(nums, index + 1, subSets, target)) {
                return true;
            }
            // 撤销
            subSets[i] -= nums[index];
        }
        // num[index] 无法加入任何一个子集
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(new Solution().canPartitionKSubsets(nums, 4));
    }
}
