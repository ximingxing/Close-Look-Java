/**
 * Description:
 * <p>
 * 滑动窗口
 * <p>
 * Created By xxm
 */
public class Solution {
    public static int longestOnes(int[] A, int K) {
        int N = A.length;
        int left = 0, right = 0;
        int res = 0;
        int zeros = 0; // 统计窗口内0元素的个数

        while (right < N) {
            // 统计窗口内0元素的个数
            if (A[right] == 0) zeros++;
            // 窗口内0的个数 <= K
            while (zeros > K) {
                // 如果 窗口内0的个数 > K, 则移动left直到遇到0元素, zeros--
                if (A[left++] == 0) zeros--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(a, 2));

        int[] b = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(b, 3));

        int[] c = new int[]{0, 0, 1, 1, 1, 0, 0};
        System.out.println(longestOnes(c, 0));
    }
}
