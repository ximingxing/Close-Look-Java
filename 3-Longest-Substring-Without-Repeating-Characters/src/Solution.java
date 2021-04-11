import java.util.HashMap;

/**
 * Description:
 * <p>
 * 滑动窗口
 * <p>
 * Created By xxm
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 窗口向右滑动的过程中不断加入字符并统计个数
            window.put(c, window.getOrDefault(c, 0) + 1);

//            System.out.println(left + " " + right);

            // 如果当前窗口中某个字符个数超过 1, 则说明出现重复字符
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            // 循环结束, 当前窗口中没有重复元素;
            // 记录窗口大小即为无重复子串长度.
            max = Math.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbb";
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
