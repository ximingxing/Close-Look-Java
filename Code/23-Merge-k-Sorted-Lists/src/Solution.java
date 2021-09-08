/**
 * Description: 合并K个升序链表
 * Solution: 将问题分解为"合并两个升序链表",之后顺次合并剩余链表
 * Created By xingximing.xxm
 */
public class Solution {

    // 合并两个升序链表
    // 见题目: #21
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2;
        ListNode cur = dummyHead;

        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        if (q != null) cur.next = q;
        if (p != null) cur.next = p;

        return dummyHead.next;
    }

    // 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        final int N = lists.length;
        if (N == 0) return null;

        ListNode ans = lists[0];
        for (int i = 1; i < N; i++) {
            ans = mergeTwoList(ans, lists[i]);
        }
        return ans;
    }
}
