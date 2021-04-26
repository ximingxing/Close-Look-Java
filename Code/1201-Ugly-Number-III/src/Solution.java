/**
 * Description:
 * 最小公倍数求法: x * y = gcd(x, y) * lcm(x, y)
 * 容斥原理: 要计算几个集合并集的大小，我们要先将所有单个集合的大小计算出来，然后减去所有两个集合相交的部分，
 * 再加回所有三个集合相交的部分，再减去所有四个集合相交的部分，依此类推，一直计算到所有集合相交的部分。
 * Created By xxm
 */
public class Solution {
    // 求最大公约数
    private long gcd(long x, long y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    // 求最小公倍数
    private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long a_b = lcm(a, b);
        long b_c = lcm(b, c);
        long a_c = lcm(a, c);
        long a_b_c = lcm(a_b, a_c);

        long l = 0, r = 2000000001;
        while (l < r) { // 二分搜索
            long mid = l + (r - l) / 2;
            // 满足条件的数的个数等于任意一个数的倍数的个数之和，减去任意两个数的公倍数个数之和，加上3个数的公倍数个数.
            if (mid / a + mid / b + mid / c - mid / a_b - mid / b_c - mid / a_c + mid / a_b_c < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) l;
    }
}
