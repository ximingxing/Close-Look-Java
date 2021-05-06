import java.util.Arrays;

/**
 * Description: 解码异或后的数组
 * Solution: 异或运算的逆运算是其本身, a^b^b = a
 * Created By xxm
 */
public class Solution {
    // 递推:
    // arr[0] = first
    // first  ^ arr[1] = encoded[0], arr[1] = encoded[0] ^ first
    // arr[1] ^ arr[2] = encoded[1], arr[2] = encoded[0] ^ arr[1]
    // arr[2] ^ arr[3] = encoded[2], arr[3] = encoded[0] ^ arr[2]

    public int[] decode(int[] encoded, int first) {
        final int len = encoded.length;
        // 原数组
        int[] arr = new int[len + 1];
        // 原数组的第一个元素
        arr[0] = first;

        for (int i = 0; i < len; i++) {
            if (i == 0)
                arr[i + 1] = encoded[i] ^ first;
            else
                arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] encoded = new int[]{1, 2, 3};
//        System.out.println(Arrays.toString(new Solution().decode(encoded, 1)));

        int[] encoded = new int[]{6, 2, 7, 3};
        System.out.println(Arrays.toString(new Solution().decode(encoded, 4)));
    }
}
