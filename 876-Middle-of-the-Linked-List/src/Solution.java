/**
 * Description:
 * <p>
 * 思路一: 计算链表长度
 * <p>
 * Created By xxm
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        // 统计链表长度n
        for (ListNode temp = head; temp != null; temp = temp.next, len++) ;
        // 取第 [n/2] 个节点
        for (len /= 2; len > 0; head = head.next, len--) ;
        return head;
    }
}
