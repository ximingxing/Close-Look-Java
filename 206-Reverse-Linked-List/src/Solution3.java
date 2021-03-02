/**
 * Description:
 * <p>
 * 顺次翻转
 * <p>
 * Created By xxm
 */
public class Solution3 {

    public static ListNode reverseList(ListNode head) {
        ListNode r = null;
        for (; head != null; ) {
            // 将temp接到表头
            ListNode temp = head;
            // 表头向后移动, 成为新表头
            head = head.next;
            // 旧表头接在r之前
            temp.next = r;
            // 更新表头
            r = temp;
        }
        return r;
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
