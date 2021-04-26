/**
 * Description:
 * <p>
 * 直接对数组排序, 第一个元素即为最小值
 * <p>
 * Created By xxm
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        quick3way(nums, 0, nums.length - 1);
        return nums[0];
    }

    private void quick3way(int[] nums, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            int cmp = Integer.compare(v, nums[i]);
            if (cmp > 0) {
                exch(nums, lt++, i++);
            } else if (cmp < 0) {
                exch(nums, i, gt--);
            } else {
                i++;
            }
        }
        // nums[lo .. lt-1] < v = nums[lt, gt] < nums[gt+1, hi]
        quick3way(nums, lo, lt - 1);
        quick3way(nums, gt + 1, hi);
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
