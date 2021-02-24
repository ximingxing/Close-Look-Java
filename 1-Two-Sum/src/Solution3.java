import java.util.Arrays;

/**
 * Description:
 * <p>
 * 双指针思想
 * <p>
 * Created By xxm
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        final int n = nums.length;
        // 使用二维数组p存储nums的值和对应下标
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = nums[i];
            p[i][1] = i;
        }
        // 需要对p排序
        Arrays.sort(p, (a, b) -> a[0] - b[0]);
        // 双指针: i从左向右, j从右向左
        for (int i = 0, j = n - 1; i < j; ) {
            int sum = p[i][0] + p[j][0];
            if (sum == target) return new int[]{p[i][1], p[i][0]};
            // 如果当前两个元素的和小于target, 则i向右移动
            // 因为当前p经过排序, 两个元素和小于target说明i指向的元素太小
            // 反之, j向左移动
            if (sum < target) i++;
            else j--;
        }
        return null;
    }
}
