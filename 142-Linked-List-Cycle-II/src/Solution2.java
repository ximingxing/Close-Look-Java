/**
 * Description:
 * <p>
 * 解法二: 快慢指针
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            if (fast.next != null) fast = fast.next.next;
            else return null;
            // 如果快慢指针相遇,
            // 从相遇点到入环点的距离加上 n-1 圈的环长
            // 恰好等于从链表头部到入环点的距离
            if (fast == slow) {
                ListNode ptr = head;
                // ptr和慢指针相遇点即为入环点
                while (ptr != null) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
