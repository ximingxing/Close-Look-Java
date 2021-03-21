/**
 * Description:
 * Created By xxm
 */
public class Solution2 {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        // 统计链表长度
        int len = 0;
        for (ListNode temp = root; temp != null; temp = temp.next)
            len++;

        // 计算k个区间包含元素的数量
        int width = len / k, rem = len % k;
        // 用于返回结果的数组
        ListNode[] res = new ListNode[k];
        // 用于遍历链表
        ListNode cur = root;
        // 遍历res数组中k个位置
        for (int i = 0; i < k; i++) {
            // head用于指向子链表表头
            ListNode head = cur;
            // 将cur移动到子链表表尾
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                // temp用来切分链表
                // 切分链表前需要将cur移动到下一个子链表到表头
                ListNode temp = cur;
                cur = cur.next;
                temp.next = null;
            }
            res[i] = head;
        }
        return res;
    }
}
