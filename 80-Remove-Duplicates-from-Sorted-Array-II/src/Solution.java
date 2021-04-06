import java.util.Arrays;

/**
 * Description:
 * <p>
 * 快慢指针
 * <p>
 * Created By xxm
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        final int N = nums.length;
        // 数组中元素不足两个跳过
        if (N < 2) return N;
        // slow: 表示新数组的size
        // fast: 表示当前等待判断的元素
        int slow = 2, fast = 2;

        while (fast < N) {
            // 存在连续三个相同元素
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
//        int arr[] = new int[]{1, 1, 1, 2, 2, 3};
//        int arr[] = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int arr[] = new int[]{1, 1, 1};
        int arr[] = new int[]{1, 2, 2, 2};
        System.out.println(new Solution().removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
