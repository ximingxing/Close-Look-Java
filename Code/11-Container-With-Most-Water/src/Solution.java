/**
 * Description: 接雨水问题
 * Solution: Two-pointers
 * 时间复杂度：O(N), 最差遍历数组一次
 * 空间复杂度: O(1)
 * Created By xingximing.xxm
 */
public class Solution {
    public int maxArea(int[] height) {
        int sum = 0; // 容器能够容纳的最大水量
        int left = 0, right = height.length - 1;
        while (left < right) { // 指针相遇为中止条件
            // left/right指向的水位中较低的为水池的宽, 长为两个指针索引之差
            int area = Math.min(height[left], height[right]) * (right - left);
            // 不断寻找最大的水池
            sum = Math.max(area, sum);
            // 移动水位较低的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(arr));

        int[] arr2 = new int[]{1, 1};
        System.out.println(new Solution().maxArea(arr2));

        int[] arr3 = new int[]{4, 3, 2, 1, 4};
        System.out.println(new Solution().maxArea(arr3));

        int[] arr4 = new int[]{1, 2, 1};
        System.out.println(new Solution().maxArea(arr4));
    }
}
