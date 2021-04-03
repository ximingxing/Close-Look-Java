/**
 * Description:
 * <p>
 * 暴力解法
 * // 左边最高的柱子和右边最高的柱子中较低的那根与当前下标i的高度差.
 * water[i] = min( max(height[0..i]), max(height[i..end]) ) - height[i]
 * <p>
 * Created By xxm
 */
public class Solution {
    public int trap(int[] height) {
        final int n = height.length;
        int res = 0;

        for (int i = 1; i < n - 1; i++) {
            // 初始化统计量: i 左右两边柱子高度
            int lMax = 0, rMax = 0;
            // 寻找 i 左边最高的柱子
            for (int j = i; j >= 0; --j) {
                lMax = Math.max(lMax, height[j]);
            }
            // 寻找 i 右边最高的柱子
            for (int j = i; j < n; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            // 第 i 个位置能注水的最大高度为其左右两边最高柱子中较低的那个与第 i 个位置的高度差.
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(arr));
    }
}
