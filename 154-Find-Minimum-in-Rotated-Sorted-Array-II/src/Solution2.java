/**
 * Description:
 * <p>
 * 二分查找
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // case 1: num[mis] < nums[right], 位于中间的元素比右边界小
                // 最小值在 mid 左侧
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // case 2: nums[mid] > nums[right], 位于中间的元素比右边界大
                // 最小值在 mid 右侧
                left = mid + 1;
            } else {
                // case 3: 当 nums[mid] == nums[right]
                // 存在相同的元素, 这时候我们收缩右边界即可.
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 2, 2, 0, 1};
        System.out.println(new Solution2().findMin(arr));

        int arr2[] = new int[]{1, 3, 5};
        System.out.println(new Solution2().findMin(arr2));

        int arr3[] = new int[]{3, 1, 3};
        System.out.println(new Solution2().findMin(arr3));
    }
}
