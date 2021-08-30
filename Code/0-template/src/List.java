/**
 * Description:
 * Created By xingximing.xxm
 */
public class List {

    public static void main(String[] args) {
        ListNode c = new ListNode(2);
        ListNode b = new ListNode(1, c);
        ListNode a = new ListNode(0, b);

        print(a);
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
