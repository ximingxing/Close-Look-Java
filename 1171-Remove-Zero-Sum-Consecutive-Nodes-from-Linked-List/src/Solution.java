import java.util.HashMap;

/**
 * Description:
 * <p>
 * 求连续若干项的和, 方法: 前缀和
 * <p>
 * Created By xxm
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // 添加哨兵
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 存储前缀和, key代表前缀和, value代表节点
        HashMap<Integer, ListNode> have = new HashMap<>();
        have.put(0, dummy);
        // 用于存储目前存储到前缀和
        int sum = 0;

        while (head != null) {
            // 记录到当前节点到前缀和
            sum += head.val;
            // 如果前缀和出现在map中,
            // 说明链表中值为sum的前缀和节点到当前节点总值和为0
            // 我们需要删除这个节点到当前节点, 并且更新用于纪录前缀和的map
            if (have.containsKey(sum)) {
                // map中值为sum到前缀和节点
                ListNode temp = have.get(sum);

                int s = sum;
                // 从temp的next一直删除到head节点 (temp, head]
                while (temp.next != head) {
                    s += temp.next.val;
                    have.remove(s); // 更新前缀和
                    temp.next = temp.next.next; // 删除temp后的节点
                }
                // 仅删除head节点(不在上面的循环中删除head, 因为要避免前缀和sum在map中被删除)
                // map中的前缀和sum保留, 不能更新
                temp.next = temp.next.next;
            } else {
                // 如果前缀和没有出现在map中, 记录其即可
                have.put(sum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }
}
