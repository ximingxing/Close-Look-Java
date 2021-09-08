import java.util.PriorityQueue;

/**
 * Description: 合并K个升序链表
 * <p>
 * Solution: 用容量为K的最小堆优先队列，把链表的头结点都放进去，
 * 然后出队当前优先队列中最小的，挂上链表，然后让出队的那个节点的下一个入队，
 * 再出队当前优先队列中最小的，直到优先队列为空。
 * <p>
 * Created By xingximing.xxm
 */
public class Solution2 {

    // 创建优先队列，并为其重新元素比较方法
    //
    PriorityQueue<ListNode> queue = new PriorityQueue<>(
            (l1, l2) -> {
                return l1.val - l2.val;
            }
    );

    // 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        final int N = lists.length;
        if (N == 0) return null;

        // 首先将k个链表的头部入队
        // 优先队列中最多存在k个元素
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummyHead = new ListNode(); // 返回结果
        ListNode cur = dummyHead; // 用于索引返回结果的链表

        while (!queue.isEmpty()) {
            // 队列中最小的元素出队
            ListNode node = queue.poll();
            // 并将其链接在cur之后
            cur.next = node;
            cur = cur.next;

            // 如果出队的元素其后还有节点，则让其入队
            ListNode nextNode = node.next;
            if (nextNode != null) queue.offer(nextNode);
        }
        return dummyHead.next;
    }
}
