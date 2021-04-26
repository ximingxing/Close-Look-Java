/**
 * Description:
 * <p>
 * 递归
 * <p>
 * Created By xxm
 */
public class Solution {

    public static ListNode reverseList(ListNode head) {
        // 如果表头为null, 则返回null
        // 如果链表只有一个节点的时候翻转后也是它自己
        if (head == null || head.next == null) {
            return head;
        }

        // 想象递归已经层层返回，到了最后一步.
        // 以链表 1->2->3->4->5 为例;
        // 现在链表变成了 5->4->3->2->null, 1->2->null (是一个链表，不是两个链表)
        // 此时newHead是5, head是1.
        ListNode newHead = reverseList(head.next);
        // 最后的操作是把链表 `1 -> 2 -> null` 变成 `1 <- 2`
        // head是1, head.next是2, head.next.next = head 就是2指向1, 此时链表为 2->1->2
        head.next.next = head;
        // 此时链表为 2->1->2, 整个链表为 5->4->3->2->1->null
        // 翻转后原来的 head 变为新链表的最后一个节点
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode d = new ListNode(4);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        print(a);
        ListNode newHead = reverseList(a);
        System.out.println(newHead);
        print(newHead);
    }

    public static void print(ListNode head) {
        StringBuilder r = new StringBuilder();
        while (head != null) {
            if (head.next == null) {
                r.append(head.val);
            } else {
                r.append(head.val).append(" -> ");
            }
            head = head.next;
        }
        System.out.println(r.toString());
    }
}
