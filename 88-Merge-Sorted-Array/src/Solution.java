import java.util.Arrays;

/**
 * Description: 88. Merge Sorted Array
 * Created By xxm
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 1 && n == 1) {
            nums1 = new int[]{nums1[0], nums2[0]};
            Arrays.sort(nums1);
            System.out.println(Arrays.toString(nums1));
            return;
        }
        for (int i = 0; i < nums2.length; i++) {
            nums1[i + nums2.length] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
//        int a[] = new int[]{1, 2, 3, 0, 0, 0};
//        int b[] = new int[]{2, 5, 6};
//        merge(a, a.length, b, b.length);

        int c[] = new int[]{0};
        int d[] = new int[]{1};
        merge(c, c.length, d, d.length);
    }
}
