import java.util.Arrays;

/**
 * Description:
 * <p>
 * 先排序, 首个元素即为nums中最小元素
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int findMin(int[] nums) {
        quick3way(nums, 0, nums.length - 1);
        return nums[0];
    }

    private void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        // nums[lo .. lt-1] < v = nums[lt, gt] < nums[gt+1 .. hi]
        quick3way(nums, lo, lt - 1);
        quick3way(nums, gt + 1, hi);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Solution2().findMin(arr));
        System.out.println(Arrays.toString(arr));
    }
}
