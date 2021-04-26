import java.util.HashSet;

/**
 * Description:
 * <p>
 * 解法二: 快慢指针
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        for (ListNode t1 = head, t2 = head; ; ) {
            // 快指针走两步
            if (t2 == null) return false;
            t2 = t2.next;
            if (t2 == null) return false;
            t2 = t2.next;
            // 慢指针走一步
            t1 = t1.next;
            // 如果快慢指针相遇, 说明链表出现环
            if (t1 == t2) return true;
        }
    }
}
