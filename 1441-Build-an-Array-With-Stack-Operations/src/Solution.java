import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 用数组模拟堆栈操作
 * Created By xxm
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        // 创建一个返回结果的数组
        ArrayList<String> res = new ArrayList<>();
        // 这里i指向target数组; cur则为递增的list, 从1开始
        for (int i = 0, cur = 1; i < target.length; cur++) {
            // 无论如何都需要入栈
            res.add("Push");
            // 如果target[i]与当前递增序列的元素不匹配, 则出栈
            if (target[i] != cur) {
                res.add("Pop");
            } else {
                i++;
            }
        }
        return res;
    }
}
