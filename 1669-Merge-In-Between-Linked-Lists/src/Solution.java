/**
 * Description:
 * <p>
 * 快慢指针
 * <p>
 * Created By xxm
 */
public class Solution {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode fast = list1, slow = list1;
        // 快指针先行 b-a+1 个节点
        for (int i = 0; i <= b - a + 1; i++, fast = fast.next) ;
        // 快慢指针以相同速度移动
        // 直到慢指针指向list1的第a-1个节点,
        // 此时快指针指向list1的第b-1个节点.
        for (int i = 0; i <= a - 1; i++, slow = slow.next, fast = fast.next) {
            if (i == a - 1) {
                // 将slow指针指向list2
                slow.next = list2;
                ListNode temp = list2;
                // 将list2的后继指向fast指针
                for (; temp.next != null; temp = temp.next) ;
                temp.next = fast;
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode list1 = new ListNode(0, a);

        ListNode c2 = new ListNode(1000002);
        ListNode b2 = new ListNode(1000001, c2);
        ListNode list2 = new ListNode(1000000, b2);

        print(list1);
        print(list2);
        ListNode newHead = mergeInBetween(list1, 3, 4, list2);
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
