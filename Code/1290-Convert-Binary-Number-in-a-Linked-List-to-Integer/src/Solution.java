/**
 * Description:
 * <p>
 * 方法: 循环遍历链表
 * 组装整数数字的二进制表示形式需要用到位运算.
 * <p>
 * Created By xxm
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            // 将数字不断左移的过程就是组装数字二进制表示形式的过程
            // 这里需要和链表节点里的数值做或运算
            res = (res << 1) | head.val;
            head = head.next;
        }
        return res;
    }
}
