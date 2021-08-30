
/**
 * Description: 将两个升序链表合并为一个新的升序链表
 * Solution: 双指针
 * Created By xingximing.xxm
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resDummy = new ListNode(0);

        ListNode p = l1, q = l2;
        ListNode res = resDummy;

        while (p != null && q != null) {
            // p, q 指向的节点均不为空
            if (p.val >= q.val) {
                res.next = new ListNode(q.val);
                q = q.next;
            } else {
                res.next = new ListNode(p.val);
                p = p.next;
            }
            res = res.next;
        }

        // 如果 p 为空时，将剩余的 q 链接在 res 之后；
        // 如果 q 为空时，将剩余的 p 链接在 res 之后。
        if (p == null) {
            res.next = q;
        } else {
            res.next = p;
        }

        return resDummy.next;
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(4);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        ListNode e = new ListNode(4);
        ListNode w = new ListNode(3, e);
        ListNode q = new ListNode(1, w);

        ListNode res = new Solution().mergeTwoLists(a, q);
        print(res);
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
