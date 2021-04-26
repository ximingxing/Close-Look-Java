/**
 * Description:
 * <p>
 * 算法: 滑动窗口
 * <p>
 * 只要子串外部每种字符个数不多于n/4即可,
 * 那么需要替换子串的最小可能长度即为滑动窗口的长度
 * <p>
 * Created By xxm
 */
public class Solution {
    public static int balancedString(String s) {
        final int n = s.length(); // 字符串长度
        int[][] nums = new int[n + 1][4]; // 存储字符前缀和的数组, 任意一段区间长度等于前缀和之差
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = nums[i - 1][j];
            }
            ++nums[i]["QWER".indexOf(s.charAt(i - 1))];
        }
        int res = n;
        // i,j为滑动窗口左右边界
        for (int i = 0, j = 0, m = n / 4; j <= n; i++) {
            for (j = Math.max(i, j);
                // 如果子串外部某个字符个数大于n/4, 则将窗口扩大, j++
                // 实现: 第n个元素的前缀和 - 当前滑动窗口内元素 = 子串外部字符个数
                // 这里需要对`Q, W, E, R`四个字符分别判断四次
                 j <= n && (nums[n][0] - (nums[j][0] - nums[i][0]) > m
                         || nums[n][1] - (nums[j][1] - nums[i][1]) > m
                         || nums[n][2] - (nums[j][2] - nums[i][2]) > m
                         || nums[n][3] - (nums[j][3] - nums[i][3]) > m);
                 j++)
                ;
            // 滑动窗口内的元素个数即为需要替换的元素个数
            if (j <= n) {
                res = Math.min(res, j - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // s.length 是 4 的倍数
        System.out.println(balancedString("QWEE"));
    }
}
