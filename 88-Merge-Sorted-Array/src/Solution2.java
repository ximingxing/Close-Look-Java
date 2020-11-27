import java.util.Arrays;

/**
 * Description: one line solution
 * Created By xxm
 */
public class Solution2 {
    public static void merge(int[] A, int m, int[] B, int n) {
        while (n > 0) A[m + n - 1] = (m == 0 || B[n - 1] > A[m - 1]) ? B[--n] : A[--m];
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 0, 0, 0};
        int b[] = new int[]{2, 5, 6};
        merge(a, a.length - b.length, b, b.length);

        int c[] = new int[]{0};
        int d[] = new int[]{1};
        merge(c, c.length - d.length, d, d.length);
    }
}
