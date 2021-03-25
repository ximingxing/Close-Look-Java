import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 倒序构造法:
 * 最初deque里放入数值最大的卡片。
 * 每次把卡片从队尾移动到队首，再从队首入队一张新卡片。
 * <p>
 * 思路: 在队列头部插入元素a时, 先将队尾元素b拿出
 * 构造[a, b]顺序, 依次从队列头部插入
 * <p>
 * Created By xxm
 */
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // 先将deck中的元素排序
        Arrays.sort(deck);

        final int n = deck.length;
        Deque<Integer> q = new LinkedList<>();
        q.add(deck[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            Integer last = q.removeLast();
            q.addFirst(last);
            q.addFirst(deck[i]);
        }

        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = q.poll();
        }
        return r;
    }
}
