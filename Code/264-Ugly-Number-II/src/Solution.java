import java.util.Arrays;

/**
 * Description:
 * Created By xxm
 */
class Solution {
    public int nthUglyNumber(int n) {
        // 如果 n 为1, 丑数对应就是它本身
        if (n == 1) return 1;

        // 根据丑数的定义,
        // 丑数: 就是只包含质因数 2、3 和/或 5 的正整数;
        // 定义三个指针: 表示下一个丑数是当前丑数乘以对应的质因数
        // 有资格同 i 相乘的最小丑数的位置
        int i2 = 1, i3 = 1, i5 = 1;
        int[] ans = new int[n + 1];
        ans[1] = 1;

        // 遍历 [2 .. n] 这个区间求出全部的丑数
        for (int i = 2; i <= n; i++) {
            // 根据丑数的定义从 1 开始找丑数
            int num2 = ans[i2] * 2, num3 = ans[i3] * 3, num5 = ans[i5] * 5;
            int ugly = Math.min(Math.min(num2, num3), num5);
            ans[i] = ugly;

            // 如果当前 i 中包含已经求出的丑数, 则移动指针向前
            // 避免重复计算
            if (ans[i] == ans[i2] * 2) i2++;
            if (ans[i] == ans[i3] * 3) i3++;
            if (ans[i] == ans[i5] * 5) i5++;
        }

        System.out.println(Arrays.toString(ans));

        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
