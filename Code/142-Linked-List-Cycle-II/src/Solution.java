import java.util.HashSet;

/**
 * Description:
 * <p>
 * 解法一: HashSet
 * <p>
 * Created By xxm
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> have = new HashSet<>();
        for (; head != null; head = head.next) {
            if (have.contains(head)) return head;
            have.add(head);
        }
        return null;
    }
}
