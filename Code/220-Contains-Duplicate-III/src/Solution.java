import java.util.TreeSet;

/**
 * Description: 滑动窗口+有序集合
 * Created By xxm
 */
public class Solution {

    // 条件一: abs(nums[i] - nums[j]) <= t
    // 条件二: abs(i - j) <= k
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final int N = nums.length;
        // 本题需要将元素类型 int 转变为 long, 否则会发生溢出
        // 这里不使用 HashSet 的原因是 HashSet 不支持范围查询
        // TreeSet 支持范围查询操作
        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            Long cur = (long) nums[i];

            // 滑动窗口中寻找小于等于 nums[i] 的元素里值最大的的元素
            Long le = window.floor(cur);
            // 滑动窗口中寻找大于等于 nums[i] 的元素里值最小的的元素
            Long ge = window.ceiling(cur);

            // 满足范围 [num[i] - t, nums[i] + t] 即可返回 true
            if (le != null && cur - le <= t) return true;
            if (ge != null && ge - cur <= t) return true;

            // 将 nums[i] 加入滑动窗口
            window.add((long) cur);

            // 维护滑动窗口大小;
            // 删除不在 [i-k, i] 范围内的元素
            if (i >= k) {
                window.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 1};
//        System.out.println(new Solution().
//                containsNearbyAlmostDuplicate(arr, 3, 0));
//
//        int[] arr2 = new int[]{1, 0, 1, 1};
//        System.out.println(new Solution().
//                containsNearbyAlmostDuplicate(arr2, 1, 2));

        int[] arr3 = new int[]{1, 5, 9, 1, 5, 9};
        System.out.println(new Solution().
                containsNearbyAlmostDuplicate(arr3, 2, 3));
    }
}
