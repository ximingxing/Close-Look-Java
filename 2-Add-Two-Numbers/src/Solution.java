/**
 * Description:
 * <p>
 * Example: 递归
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Created By xxm
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int carry = 0;
        addTwoNumbersRecursion(l1, l2, cur, 0);
        return dummyHead.next;
    }

    private void addTwoNumbersRecursion(ListNode p, ListNode q, ListNode cur, int carry) {
        if (carry > 0) cur.next = new ListNode(carry);

        if (p == null && q == null) {
            return;
        }

        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;

        int sum = x + y + carry;

        cur.next = new ListNode(sum % 10); // 余数

        if (p != null) p = p.next;
        if (q != null) q = q.next;

        addTwoNumbersRecursion(p, q, cur.next, sum / 10);
    }
}
