/**
 * Description:
 * <p>
 * 双指针解法
 * // 左边最高的柱子和右边最高的柱子中较低的那根与当前下标i的高度差.
 * water[i] = min( max(height[0..i]), max(height[i..end]) ) - height[i]
 * <p>
 * Created By xxm
 */
public class Solution3 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        final int n = height.length;
        int res = 0;

        // 声明双指针
        int left = 0, right = n - 1;
        int lMax = height[left], rMax = height[right];

        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            // 我们需要 l_max < r_max ,
            // 至于这个 r_max 是不是右边最大的, 不重要;
            // 重要的是 height[i] 能够装的水只和较低的 l_max 之差有关.
            if (lMax < rMax) {
                res += Math.min(lMax, rMax) - height[left];
                left++;
            } else {
                res += Math.min(lMax, rMax) - height[right];
                right--;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution3().trap(arr));
    }
}
