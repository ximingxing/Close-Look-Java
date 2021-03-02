import javafx.util.Pair;

/**
 * Description:
 * <p>
 * 递归
 * <p>
 * Created By xxm
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        
    }
}
