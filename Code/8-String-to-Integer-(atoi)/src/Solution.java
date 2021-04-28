/**
 * Description: 将字符串转化为整数
 * 需要注意的是字符串中不止有整数, 已经处理整数溢出的情况.
 * Solution: 模拟
 * Created By xxm
 */
public class Solution {
    public int myAtoi(String s) {
        final int N = s.length();
        int sign = 1; // 符号位
        int idx = 0; // 字符串 s 索引

        /* 1. 读入前导空格 */
        while (idx < N && s.charAt(idx) == ' ') {
            idx++;
        }

        // 排除极端情况 (所有字符均为空格: "      ")
        if (idx == N) return 0;

        /* 2. 记录符号位 */
        if (s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (s.charAt(idx) == '+') {
            idx++;
        }

        int ans = 0; // 存储结果的整数
        int last = 0; // 存储上一次的结果
        // 从 idx 开始遍历
        for (; idx < N; idx++) {
            char c = s.charAt(idx);

            /* 3. 如果符号位后的第一个字符不是数字, 则返回 */
            if (c > '9' || c < '0') {
                break;
            }

            /* 4. 记录合法的整数 */
            last = ans;
            // 取出字符串中字符, 然后转化为数字
            ans = ans * 10 + sign * (c - '0');
            // 越界处理: 如果 last 与 ans/10 不相等即为溢出
            if (last != ans / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("42"));
        System.out.println(new Solution().myAtoi("4193 with words"));
        System.out.println(new Solution().myAtoi("       "));
        System.out.println(new Solution().myAtoi("   -50000   "));
        System.out.println(new Solution().myAtoi("-91283472332"));
        System.out.println(new Solution().myAtoi("words and 987"));
    }
}
