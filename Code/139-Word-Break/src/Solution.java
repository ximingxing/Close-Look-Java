import java.util.HashSet;
import java.util.List;

/**
 * Description:
 * <p>
 * 动态规划
 * <p>
 * Created By xxm
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 用来存储字典
        HashSet<String> dict = new HashSet<>(wordDict);

        // dp[i] 定义:
        // 长度为 i 的 s[0 .. i-1] 子串是否能拆分成单词.
        boolean[] dp = new boolean[s.length() + 1];

        // base case
        dp[0] = true;

        // 通过 s[0, j-1] 是否构成字典中的单词
        // 剩余字符串 s[j, i] 能否构成字典里的单词
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }

        return dp[s.length()];
    }
}
