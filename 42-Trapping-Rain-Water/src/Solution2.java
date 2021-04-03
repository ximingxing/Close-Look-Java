/**
 * Description:
 * <p>
 * 带有备忘录的解法:
 * // 左边最高的柱子和右边最高的柱子中较低的那根与当前下标i的高度差.
 * water[i] = min( max(height[0..i]), max(height[i..end]) ) - height[i]
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        final int n = height.length;
        int res = 0;
        // 声明备忘录
        int[] lMax = new int[n], rMax = new int[n];
        // 初始化备忘录
        lMax[0] = height[0];
        rMax[n - 1] = height[n - 1];

        // 计算每个位置左边最高的柱子
        for (int i = 1; i < n; ++i) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        // 计算每个位置右边最高的柱子
        for (int j = n - 2; j >= 0; --j) {
            rMax[j] = Math.max(height[j], rMax[j + 1]);
        }

        // 计算蓄水量
        for (int k = 0; k < n; k++) {
            res += Math.min(lMax[k], rMax[k]) - height[k];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution2().trap(arr));
    }
}
