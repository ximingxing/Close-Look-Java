/**
 * Description:
 * <p>
 * 就是想默写一下快排 ^_^
 * 这里使用双指针解法
 * <p>
 * Created By xxm
 */
public class Solution2 {

    private void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void quick3way(int[] nums, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            int cmp = Integer.compare(nums[i], v);
            if (cmp > 0) {
                exchange(nums, i, gt--);
            } else if (cmp < 0) {
                exchange(nums, lt++, i++);
            } else {
                i++;
            }
        }
        // nums[lo .. lt-1] < v = nums[lt, gt] < nums[gt+1 .. hi]
        quick3way(nums, lo, lt - 1);
        quick3way(nums, gt + 1, hi);
    }

    public boolean search(int[] nums, int target) {
        final int N = nums.length;
        if (N == 0) return false;
        quick3way(nums, 0, N - 1);
        for (int i = 0, j = N - 1; i < N && j >= 0; i++, j--) {
            if (target == nums[i] || target == nums[j]) {
                return true;
            }
            if (i == j) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 6, 0, 0, 1, 2};
//        int[] arr = new int[]{1, 3};
        System.out.println(new Solution2().search(arr, 0));
    }
}
