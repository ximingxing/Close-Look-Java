/**
 * Description: 简单贪心
 * Created By xxm
 */
public class Solution {
    public int balancedStringSplit(String s) {
        if (s.isEmpty()) return 0;
        // 用于标记字符串平衡的量
        int dep = 0;
        // 返回平衡字符串的最大数量
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                dep++;
            } else {
                dep--;
            }
            if (dep == 0) res++;
        }
        return res;
    }
}
