/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        // 统计链表长度
        int len = 0;
        for (ListNode temp = root; temp != null; temp = temp.next)
            len++;

        // 计算k个区间包含元素的数量
        int width = len / k, rem = len % k;

        // 新建链表返回结果
        ListNode[] res = new ListNode[k];
        // 用于遍历链表
        ListNode cur = root;
        // 遍历res数组中k个位置
        for (int i = 0; i < k; i++) {
            // head用于保存每个子链表的表头
            // write为head后新建链接的元素
            ListNode head = new ListNode(0), write = head;
            // 遍历每个需要切分的区间
            // 这里len无法整除k时, 需要有一些区间多一个元素
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                //
                write = write.next = new ListNode(cur.val);
                // 顺次移动
                cur = cur.next;
            }
            res[i] = head.next;
        }
        return res;
    }
}
