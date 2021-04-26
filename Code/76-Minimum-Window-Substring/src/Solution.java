import java.util.HashMap;

/**
 * Description:
 * <p>
 * 滑动窗口
 * <p>
 * Created By xxm
 */
public class Solution {
    public String minWindow(String s, String t) {
        char[] arr = s.toCharArray();
        char[] target = t.toCharArray();

        // 将需要覆盖的子串 t 中的字符加入 need 中
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : target) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 用于记录窗口中包含 t 中字符的个数
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        // 用于记录 need 中元素个数
        int valid = 0;
        // 用于记录返回的子串
        int start = 0, len = Integer.MAX_VALUE;

        while (right < arr.length) {
            // c 是即将加入窗口的字符
            char c = arr[right];
            // 将窗口右移
            right++;
            // 如果 c 在 need 中, 就将其加入 window, 并将 valid+1
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 此时窗口中已经包含 t 中全部字符, 开始收缩窗口
            while (valid == need.size()) {
                // 如果存在更小的子串, 更新返回子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 将字符 d 移除窗口
                char d = arr[left];
                // 左移窗口
                left++;
                // 如果 d 在 need 中, 则更新 window 中的状态: 将 d 出现的次数减一
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

//        String s = "a";
//        String t = "aa";
        System.out.println(new Solution().minWindow(s, t));
    }
}
