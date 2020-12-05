import java.util.Arrays;

/**
 * Description: 88. Merge Sorted Array
 * <p>
 * Runtime: 0ms
 * Memory : 39.1MB
 * <p>
 * Created By xxm
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0 && j != nums2.length) {
                nums1[i] = nums2[j++];
            }
        }
        Arrays.sort(nums1);
//        System.out.println(nums1);
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 0, 0, 0};
        int b[] = new int[]{2, 5, 6};
        merge(a, a.length + b.length, b, b.length);

        int c[] = new int[]{0};
        int d[] = new int[]{1};
        merge(c, 0, d, 1);
    }
}
