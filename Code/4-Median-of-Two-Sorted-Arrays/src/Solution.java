/**
 * Description: 寻找两个升序数组合并后的中位数, 要求时间复杂度 O(log(m+n))
 * Solution: 二分查找
 * Created By xxm
 */
public class Solution {

    /* 将原问题转化为: 寻找有序数组中第 k 小的元素*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        int totalLength = m + n;
        double mid;
        if (totalLength % 2 == 1) {
            // 当 m+n 是奇数时, 中位数是两个有序数组的第 (m+n)/2 个元素.
            int midIndex = totalLength / 2;
            mid = getKthElement(nums1, nums2, midIndex + 1);
        } else {
            // 当 m+n 是偶数时, 中位数是两个有序数组的第 (m+n)/2 和 (m+n)/2+1 个元素的平均值.
            int midIndex1 = totalLength / 2 - 1;
            int midIndex2 = totalLength / 2;
            mid = getKthElement(nums1, nums2, midIndex1 + 1)
                    + getKthElement(nums1, nums2, midIndex2 + 1);
            mid /= 2.0;
        }
        return mid;
    }

    /* 寻找有序数组中第 k 小的元素
     * 方法: 二分查找, 已知有 17 个元素, 要寻找的中位数是第 9 个. */
    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            /* 处理边界情况 */
            // 如果第二个数组索引结束, 直接返回另一个数组中第 k 小的元素.
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            // 如果第二个数组索引结束, 直接返回另一个数组中第 k 小的元素.
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            // 如果 k 为 1, 取两个数组首元素中较小的.
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            /* 正常情况 */
            // 要找到第 k (k>1) 小的元素, 那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid, len1) - 1;
            int newIndex2 = Math.min(index2 + mid, len2) - 1;

            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            // 如果 pivot1 <= pivot2, 则第 k 小元素肯定不在 nums1[0 .. k/2] 之中
            // 反之依然, 直到触及边界条件时停止.
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
