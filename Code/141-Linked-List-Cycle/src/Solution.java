import java.util.HashSet;

/**
 * Description:
 * <p>
 * 解法一: HashSet
 * <p>
 * Created By xxm
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> have = new HashSet<>();

        for (; head != null; head = head.next) {
            if (have.contains(head)) return true;
            have.add(head);
        }
        return false;
    }
}
