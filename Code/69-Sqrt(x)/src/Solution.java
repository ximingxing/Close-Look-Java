/**
 * Description:
 * <p>
 * 由于x平方根的整数部分ans是满足`k^2 <= x`的最大值k值
 * <p>
 * Created By xxm
 */
public class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;
        while (left <= right) {
//            final int mid = left + (right - left) / 2;
            final long mid = (right + left) >> 1;
            if (mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }
}
