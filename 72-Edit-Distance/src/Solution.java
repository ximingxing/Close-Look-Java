import javafx.util.Pair;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * 自顶向下带有备忘录的递归
 * <p>
 * Created By xxm
 */
public class Solution {
    // 备忘录, 存储已经计算过的情况, 减小计算量
    // key: (i, j), value: 对应的最小编辑距离.
    HashMap<Pair<Integer, Integer>, Integer> memo;

    // 求三个数中的最小值
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    /* 递归函数: 计算字符串 s1 变为 s2 的最小编辑距离*/
    private int dp(String s1, int i, String s2, int j) {
        // 递归出口
        // 当 s1 长度为 0 时, 将 s2 剩余的字符插入到 s1, 同理;
        // 当 s2 长度为 0 时, 将 s1 剩余的字符删除
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        Pair<Integer, Integer> pair = new Pair<>(i, j);
        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果当前字符相同
            // 则什么也不做, i 和 j 一起向前移动
            int dp = dp(s1, i - 1, s2, j - 1);
            memo.put(pair, dp);
            return dp;
        } else {
            // 如果 s1[i] != s2[j], 说明当前字符不同
            // 则进行 插入, 删除, 替换 之中能使编辑距离最小的操作(代价最小)
            // 插入: 将 s2 的字符插入到 s1
            int dp = min(dp(s1, i, s2, j - 1), // 插入
                    dp(s1, i - 1, s2, j), // 删除
                    dp(s1, i - 1, s2, j - 1) // 替换
            ) + 1;
            memo.put(pair, dp);
            return dp;
        }
    }

    public int minDistance(String word1, String word2) {
        memo = new HashMap<>();
        // 按照从字符串尾部向前遍历
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        System.out.println(new Solution().minDistance(s1, s2));
    }
}
