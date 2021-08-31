import java.util.LinkedList;
import java.util.List;

/**
 * Description: 括号生成
 * Solution: 回溯 + 减枝
 * Created By xingximing.xxm
 */
public class Solution {
    // 保存全部结果的集合
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        backtrace(n, n, "");
        return res;
    }

    /**
     * "回溯 + 剪枝"生成全部合法的括号
     *
     * @param left  剩余可用的左括号数目
     * @param right 剩余可用的右括号的数目
     * @param path  DFS轨迹，即当前括号合集
     */
    private void backtrace(int left, int right, String path) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }

        // 剪枝：任何时候左括号的数目都小于右括号的数目
        if (left > right) return;

        if (left > 0) {
            backtrace(left - 1, right, path + "(");
        }
        if (right > 0) {
            backtrace(left, right - 1, path + ")");
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
