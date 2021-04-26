import java.util.HashMap;

/**
 * Description:
 * 使用桶排序的思想: 我们按照元素的大小进行分桶，维护一个滑动窗口内的元素对应的元素。
 * <p>
 * 对于元素x, 其影响的区间为 [x−t,x+t];
 * ---
 * 对于数组中任意数字x, x // t+1 可以将数组装进不同的桶中,
 * 且桶中的数字满足 abs(nums[i] - nums[j]) <= t.
 * ---
 * 于是我们可以设定桶的大小为 `t+1`;
 * 如果两个元素同属一个桶, 那么这两个元素必然符合条件;
 * 如果两个元素属于相邻桶, 那么我们需要校验这两个元素是否差值不超过 `t`;
 * 如果两个元素既不属于同一个桶, 也不属于相邻桶, 那么这两个元素必然不符合条件.
 * <p>
 * Created By xxm
 */
public class Solution2 {

    // 条件一: abs(nums[i] - nums[j]) <= t
    // 条件二: abs(i - j) <= k
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final int N = nums.length;
        // 本题需要将元素类型 int 转变为 long, 否则会发生溢出

        // 使用 HashMap 维护所有桶
        HashMap<Long, Long> bucketSet = new HashMap<>();
        // 目的是为了确保差值小于等于 t 的数能够落到一个桶中
        // 因为差值为 t 两个数在数轴上相隔距离为 t + 1，它们需要被落到同一个桶中。
        long size = (long) t + 1;

        for (int i = 0; i < N; i++) {
            // 获取当前 nums[i] 对应桶的 id
            long bucketId = getId(nums[i], size);

            // 如果 nums[i] 所属的桶已经存在, 说明我们找到一对符合条件的元素
            if (bucketSet.containsKey(bucketId)) return true;

            // 否则我们继续检查两个相邻的桶内是否存在符合条件的元素;
            // 因为相邻的两个桶距离小于等于t, 即桶中元素值之差小于等于t
            if (bucketSet.containsKey(bucketId - 1)
                    && Math.abs(nums[i] - bucketSet.get(bucketId - 1)) < size) {
                return true;
            }
            if (bucketSet.containsKey(bucketId + 1)
                    && Math.abs(nums[i] - bucketSet.get(bucketId + 1)) < size) {
                return true;
            }

            // 如果都不存在, 则新建桶
            bucketSet.put(bucketId, (long) nums[i]);

            // 维护桶的数量, 即维护 abs(i - j) <= k
            if (i >= k) {
                bucketSet.remove(getId(nums[i - k], size));
            }
        }
        // 没有找到符合题意的元素
        return false;
    }

    /* 根据元素值 (nums[i]) 返回元素所在桶的 id */
    private long getId(long x, long t) {
        /**
         * getID(-4,3) = -2
         * getID(-3,3) = -1
         * getID(-2,3) = -1
         * getID(-1,3) = -1
         * -----
         * 首先x为什么要加一，t=3时，桶0是包含0的，应该包含0、1、2，这些数字可以直接被t整除成0；
         * 桶-1应该从-1开始，包含-1、-2、-3，-3被整除的话是-1，因此x+1是让负数整体先右移，方便被整除。
         * 其次为什么最后要减一，同样以上面的例子，桶-1中-1、-2、-3整除完是0，-1是为了让负数桶整体左移一位，
         * 这样就不会在桶0处冲突了。
         */
        if (x >= 0)
            return x / t;
        return (x + 1) / (t - 1);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 1};
//        System.out.println(new Solution().
//                containsNearbyAlmostDuplicate(arr, 3, 0));
//
//        int[] arr2 = new int[]{1, 0, 1, 1};
//        System.out.println(new Solution().
//                containsNearbyAlmostDuplicate(arr2, 1, 2));

        int[] arr3 = new int[]{2147483647, -1, 2147483647};
        System.out.println(new Solution2().
                containsNearbyAlmostDuplicate(arr3, 1, 2147483647));
    }
}
