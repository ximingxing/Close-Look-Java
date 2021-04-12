import java.util.Arrays;

/**
 * Description:
 * Created By xxm
 */
public class Solution {
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /* 两数字比较大小规则 */
    private static int compare(int a, int b) {
        String x = a + "";
        String y = b + "";
        // 比较两个字符串拼接后字典大小
        return (x + y).compareTo(y + x);
    }

    /* 快速排序 */
    private void quick3way(int[] nums, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];

        while (i <= gt) {
            int cmp = compare(v, nums[i]);
            if (cmp > 0) {
                exch(nums, lt++, i++);
            } else if (cmp < 0) {
                exch(nums, i, gt--);
            } else {
                i++;
            }
        }
        // nums[lo .. lt - 1] < v = nums[lt, gt] < nums[gt+1 .. hi]
        quick3way(nums, lo, lt - 1);
        quick3way(nums, gt + 1, hi);
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 1) return nums[0] + "";

        quick3way(nums, 0, nums.length - 1);

//        System.out.println(Arrays.toString(nums));

        StringBuilder ans = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.append(nums[i]);
        }
        // 特殊情况: 输入为若干个0
        if (ans.charAt(0) == '0')
            return "0";
        return ans.toString();
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{3, 30, 34, 5, 9};
//        int[] arr = new int[]{10};
//        int[] arr = new int[]{10, 2};
        int[] arr = new int[]{0, 0};
        System.out.println(new Solution().largestNumber(arr));
    }
}
