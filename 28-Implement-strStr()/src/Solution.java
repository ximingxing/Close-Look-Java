/**
 * Description: 朴素字符串匹配
 * Created By xxm
 */
public class Solution {

    /* 枚举 haystack 中每个字符作为起点, 每次从原串起点出发与 needle 起点开始匹配 */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        // 枚举原串每个字符作为起始点
        for (int i = 0; i <= n - m; i++) {
            // 从原串开始和匹配串的首位开始, 尝试匹配
            int a = i, b = 0;
            while (b < m && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            // 如果能够完全匹配, 返回原串的起点下标
            if (b == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "", needle = "";
//        String haystack = "a", needle = "";
//        String haystack = "", needle = "a";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
