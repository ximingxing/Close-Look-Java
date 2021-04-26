import java.util.*;

/**
 * Description: 回溯算法
 * Created By xxm
 */
public class Solution {
    List<String> ans;
    List<Character> track;
    Map<Character, String> map;

    /*  */
    private void backtrace(String digits, int index, StringBuilder combine) {
        // 产生一个合法的组合
        if (index == digits.length()) {
            ans.add(combine.toString());
            return;
        }

        // 从输入数字中获得对于可选择的字母
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        // 遍历全部字母
        for (int i = 0; i < letters.length(); i++) {
            // 做选择
            combine.append(letters.charAt(i));
            // 递归的为 combine 选择下一个字母
            backtrace(digits, index + 1, combine);
            // 撤销选择
            combine.deleteCharAt(index);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new LinkedList<>();
        map = mapDigit2Letters();
        ans = new LinkedList<>();
        track = new LinkedList<>();
        backtrace(digits, 0, new StringBuilder());
        return ans;
    }

    private Map<Character, String> mapDigit2Letters() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().letterCombinations("23");
        System.out.println(Arrays.toString(strings.toArray()));
    }
}
