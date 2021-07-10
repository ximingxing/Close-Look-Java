/**
 * Description: 寻找字符串集合中全部字符串的最长公共子串
 * Solution: 横向扫描
 * Created By xingximing.xxm
 */
public class Solution {

    // 找出字符串a和b的最长公共子串
    private String longestCommonPrefix(String str1, String str2) {
        // 最长公共子串理论最长的长度即str1和str2中较短的长度
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    // 寻找字符串集合中全部字符串的最长公共子串
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        // 依次遍历字符串集合, 对于每次遍历到的字符串, 更新最长公共前缀
        for (int i = 1; i < strs.length; i++) {
            ans = longestCommonPrefix(ans, strs[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{
                "abc", "abcd", "abcde"
        }));
    }
}
