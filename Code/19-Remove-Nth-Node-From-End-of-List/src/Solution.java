/**
 * Description: 删除链表的倒数第n个节点 (仅遍历链表一次)
 * Solution: 快慢指针
 * Created By xingximing.xxm
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        // Noting: 这里希望fast到链表尾部的时候,
        // slow正好指向倒数第n个节点的前一个节点, 方便执行删除操作
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;

        // fast走n步, slow走1步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode res = new Solution().removeNthFromEnd(a, 2);
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
