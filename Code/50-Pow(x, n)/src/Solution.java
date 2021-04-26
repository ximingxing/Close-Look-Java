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
        if (n == 0) return 1.0;
        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long m = n; // n为负数时取相反数可能溢出
        return m < 0 ? (1. / pow(x, -m)) : pow(x, m); // n可能为负数
    }

}
