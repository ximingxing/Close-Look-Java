import java.util.*;

/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 标记 p 中的字符
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        List<Integer> ans = new ArrayList<>();

        int left = 0, right = 0;
        int isValid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c)))
                    isValid++;
            }

            while (right - left >= p.length()) {
                // 找到 p 的一个字母异位词
                if (isValid == need.size())
                    ans.add(left);

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        isValid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd", p = "abc";
//        String s = "abab", p = "ab";
        String s = "baa", p = "aa";
        List<Integer> ans = new Solution().findAnagrams(s, p);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
