/**
 * Description: 将链表各个元素按位相加
 * Solution: 递归
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Created By xxm
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建有哑节点的 cur, 用于保存结果的链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // p, q 分别用来遍历 l1 和 l2
        ListNode p = l1, q = l2;
        // 用于保存进位的 carry
        int carry = 0;

        addTwoNumbersRecursion(l1, l2, cur, carry);
        return dummyHead.next;
    }

    private void addTwoNumbersRecursion(ListNode p, ListNode q, ListNode cur, int carry) {
        // 如果进位大于0, 则为 cur 新建一个节点
        if (carry > 0) cur.next = new ListNode(carry);

        // 递归出口
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
