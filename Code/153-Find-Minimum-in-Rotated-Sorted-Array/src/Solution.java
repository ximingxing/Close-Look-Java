/**
 * Description:
 * <p>
 * 二分查找
 * 关键: 判断最小值元素在 mid 的左侧还是右侧。
 * <p>
 * Created By xxm
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                // 最小值在 mid 左侧
                // 所以可以忽略 mid 右侧部分
                right = mid;
            } else {
                // 最小值在 mid 右侧
                // 所以可以忽略 mid 左侧部分
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Solution().findMin(arr));
    }
}
