/**
 * Description:
 * <p>
 * 二分查找
 * <p>
 * Created By xxm
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        // 二分查找 target 出现的左边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        // 判断 left 是否越界, nums[left] 是否为目标值
        if (left >= nums.length || nums[left] != target) return new int[]{-1, -1};
        right = left;

        // 从left开始遍历, 统计相同 target 的位置
        for (int i = left; i < nums.length; i++) {
            if (nums[i] == target) right++;
            else break;
        }
        return new int[]{left, right - 1};
    }
}
