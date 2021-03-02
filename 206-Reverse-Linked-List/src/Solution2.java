import java.util.Stack;

/**
 * Description:
 * <p>
 * 利用堆栈
 * <p>
 * Created By xxm
 */
public class Solution2 {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 将链表节点顺次压入堆栈
        Stack<ListNode> stack = new Stack<>();
        for (; head != null; head = head.next) {
            stack.push(head);
        }
        // 将堆栈中的元素弹出的顺序即为链表翻转后的顺序
        ListNode newHead = stack.pop();
        ListNode temp = newHead;
        while (stack.size() != 0) {
            ListNode cur = stack.pop();
            cur.next = null;
            temp.next = cur;
            temp = temp.next;
        }
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
