/**
 * Description:
 * <p>
 * 思路二: 快慢指针
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public ListNode middleNode(ListNode head) {
        // 快指针每次走两步, 慢指针每次走一步
        for (ListNode temp = head; temp != null && temp.next != null; temp = temp.next.next, head = head.next) ;
        return head;
    }
}
