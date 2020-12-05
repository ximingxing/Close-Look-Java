import java.util.Arrays;

/**
 * Description: one line solution
 * <p>
 * Runtime: 0ms
 * Memory : 39.4MB
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public static void merge(int[] num1, int m, int[] num2, int n) {
        while (n > 0) num1[m + n - 1] = (m == 0 || num2[n - 1] > num1[m - 1]) ? num2[--n] : num1[--m];
//        System.out.println(Arrays.toString(num1));
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 0, 0, 0};
        int b[] = new int[]{2, 5, 6};
        merge(a, 3, b, 3);

        int c[] = new int[]{0};
        int d[] = new int[]{1};
        merge(c, 0, d, 1);
    }
}
