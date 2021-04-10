import java.util.HashMap;

/**
 * Description:
 * <p>
 * 判断 s2 中是否存在 s1 的排列
 * <p>
 * Created By xxm
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // 将 s1 中的字符存入 map 之中
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        // 记录窗口中 s1 字符出现的次数
        HashMap<Character, Integer> window = new HashMap<>();

        // 滑动窗口左右边界
        int left = 0, right = 0;
        // 标记 s1 中有多少字符进入窗口中
        int isValid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 如果字符 c 在 s1 之中,
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    isValid++;
            }

            // 让 right 一直右移直到 s1 的全部字符进入窗口之中;
            // 然后判断左侧窗口是否要收缩, 窗口大小为 s1 的长度
            while (right - left >= s1.length()) {
                // 是否找到合法的子串
                if (isValid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                // d 是 s1 之中的字符
                if (need.containsKey(d)) {
                    // 更新 window 中的数据
                    if (need.get(d).equals(window.get(d)))
                        isValid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 未找到子串
        return false;
    }

    public static void main(String[] args) {
//        String s1 = "ab", s2 = "eidbaooo";
//        String s1 = "ab", s2 = "eidboaoo";
        String s1 = "hello", s2 = "ooolleoooleh";
        System.out.println(new Solution().checkInclusion(s1, s2));
    }
}
