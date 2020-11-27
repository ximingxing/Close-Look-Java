import java.util.Arrays;

/**
 * Description: 66. Plus One
 * Created By xxm
 */
public class Solution {
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }
        if (digits.length == 1) {
            digits[0] += 1;
            if ((digits[0]) >= 10) {
                return new int[]{1, digits[0] - 10};
            } else
                return new int[]{digits[0]};
        }

        int plus = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            // last item plus one
            if (i == digits.length - 1) {
                digits[i] += 1;
            }
            // item plus carry
            digits[i] += plus;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                plus = 1;
            } else {
                plus = 0;
            }
            // items
            if (i == 0 && plus != 0) {
                int[] ints = new int[digits.length + 1];
                ints[0] = 1;
                System.arraycopy(digits, 0, ints, 1, digits.length);
                return ints;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 9};
        int b[] = new int[]{9};
        int c[] = new int[]{0};
        int d[] = new int[]{9, 9};

        int[] aa = plusOne(a);
        System.out.println(Arrays.toString(aa));
        int[] bb = plusOne(b);
        System.out.println(Arrays.toString(bb));
        int[] cc = plusOne(c);
        System.out.println(Arrays.toString(cc));
        int[] dd = plusOne(d);
        System.out.println(Arrays.toString(dd));
    }
}
