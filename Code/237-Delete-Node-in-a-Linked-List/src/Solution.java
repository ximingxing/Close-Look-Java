/**
 * Description:
 * <p>
 * 节点的懒删除.
 * <p>
 * Created By xxm
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
