/**
 * Description: 整数翻转
 * 数据范围: [−2^31, 2^31−1]
 * <p>
 * Solution: 位运算
 * 如何翻转整数? 相比于字符串的翻转;
 * 翻转整数可以通过取模运算(%)得到末尾数字, 然后反向拼接.
 * <p>
 * Created By xxm
 */
public class Solution {

    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        int ans = 0; // 存放翻转后的整数

        // 结束条件: 无论正数还是负数, 不断的/10这样的操作 (向下取整),
        // 最后都会变成0, 所以判断终止条件就是!=0
        while (x != 0) {
            // 取模运算: 得到整数的末尾数字
            int last = x % 10;

            /* 原数字是合法范围内的数字, 但是反转过来就超过范围 */
            // 判断ans是否大于最大32位整数
            if (ans > MAX / 10 || (ans == MAX / 10 && last > 7)) {
                return 0; // 溢出返回0
            }
            // 判断ans是否小于最小32位整数
            if (ans < MIN / 10 || (ans == MIN / 10 && last < -8)) {
                return 0; // 溢出返回0
            }

            // 翻转整数
            ans = ans * 10 + last;
            // 缩小原整数
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(12345));
    }
}
