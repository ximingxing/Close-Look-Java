/**
 * Description: 将链表各个元素按位相加
 * Solution: 模拟
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Created By xxm
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建有哑节点的 cur, 用于保存结果的链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // p, q 分别用来遍历 l1 和 l2
        ListNode p = l1, q = l2;
        // 用于保存进位的 carry
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // 将 p, q 按位相加, 并加上前一位的进位
            int sum = carry + x + y;
            // 更新进位
            carry = sum / 10;
            // 更新 cur
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            // 更新 p, q
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // 如果进位不为0, 则还需要追加一个新节点
        if (carry > 0) cur.next = new ListNode(carry);

        return dummyHead.next;
    }

}
