/**
 * Description:
 * <p>
 * 题目提示范围很关键.
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * <p>
 * Created By xxm
 */
public class Solution {

    // 快速模取幂算法
    private double pow(double x, long n) {
        double r = 1;
        // 在对 N 进行二进制拆分的同时计算答案
        for (; n > 0; n >>= 1) {
            // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
            if ((n & 1) == 1) {
                r *= x;
            }
            // 将贡献不断地平方
            x *= x;
        }
        return r;
    }

    public double myPow(double x, int n) {
        long m = n; // n为负数时取相反数可能溢出
        return m < 0 ? (1. / pow(x, -m)) : pow(x, m); // n可能为负数
    }
}
