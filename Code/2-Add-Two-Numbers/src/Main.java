/**
 * Description:
 * Created By xxm
 */
public class Main {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//
//        Solution ss = new Solution();
//        ListNode res = ss.addTwoNumbers(l1, l2);
//
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }

        System.out.println("-------------");

        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(5);

        Solution ss1 = new Solution();
        ListNode res1 = ss1.addTwoNumbers(l3, l4);

        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.next;
        }

//        System.out.println("-------------");
//
//        ListNode l5 = new ListNode(1);
//        l5.next = new ListNode(8);
//        ListNode l6 = new ListNode(0);
//
//        Solution2 ss2 = new Solution2();
//        ListNode res2 = ss2.addTwoNumbers(l5, l6);
//
//        while (res2 != null) {
//            System.out.println(res2.val);
//            res2 = res2.next;
//        }
    }
}
