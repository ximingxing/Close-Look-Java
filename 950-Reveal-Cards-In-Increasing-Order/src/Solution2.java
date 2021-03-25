import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * 顺序构造法:
 * 即直接模拟抽牌的过程.
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int[] deckRevealedIncreasing(int[] deck) {
        final int n = deck.length;
        // 使用队列保存元素下标
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            q.add(i);
        }
        // 对数组进行排序
        Arrays.sort(deck);
        // 用于存储返回的结果
        int[] r = new int[n];
        // 遍历排序后的deck
        // 将最小的牌放入下标为0的位置, 次小放入2, 再次小放入4
        // 以此类推
        for (int card : deck) {
            r[q.poll()] = card;
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return r;
    }
}
