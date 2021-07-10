import java.util.HashMap;

/**
 * Description: 罗马数字转阿拉伯数字
 * Solution: 模拟
 * Created By xingximing.xxm
 */
public class Solution {
    // roman到int的映射规则
    HashMap<Character, Integer> dict = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int value = dict.get(s.charAt(i));
            // 根据罗马数字规则: 如果小的数字在大的数字左边, 则需要减掉这个小的数字
            if (i < len - 1 && dict.get(s.charAt(i + 1)) > value) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}
