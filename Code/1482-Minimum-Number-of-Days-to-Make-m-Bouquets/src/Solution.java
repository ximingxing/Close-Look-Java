/**
 * Description:
 * <p>
 * 注意审题: 这道题目不能二分数组或者对数组排序.
 * 思路:
 * (1) 要找到从花园中摘m束花需要等待的天数day,
 * 我们假设有一个函数 canMake(int day, int m, int k)
 * 给定等待天数day、m束、k朵, 可以返回是否可以制作.
 * 那么根据题目条件我们可以从[0, 10^9]这个等待天数区间
 * 中二分查找最少的等待天数.
 * (2) 现在要解决的问题就是 canMake() 函数
 * 如果数组中的元素值大于给定的天数，
 * 那说明这个元素(也就是这朵花)还不能摘反之可以摘，
 * 每摘一朵k--，如果摘了k朵k就会等于0，
 * 这就说明可以制作1束那m就可以减减，然后重新制作下一束，循环继续。
 * 但是需要注意的s是因为题目要求花必须挨着，
 * 所以一旦遇到不可摘的花就需要重新计算k的值，
 * 也就是k不能再--了需要恢复到最早的k值.
 * <p>
 * Created By xxm
 */
public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // 总共需要`m*k`朵花,
        if (bloomDay.length / k < m) return -1;
        // 在[0, 10^9]这个等待天数区间中寻找最小等待区间
        int left = 0, right = 1000000000;
        // 二分搜索
        while (left <= right) {
            int mid = (right + left) / 2;
            // 如果当前的天数mid满足m束k朵的条件
            // 则尝试继续寻找更小的天数
            if (canMake(bloomDay, mid, m, k)) {
                right = mid - 1;
            } else {
                // 如果当前等待天数mid不满足条件
                // 则放宽等待天数
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 根据指定天数day计算是否可以完成每m束每束k朵花的制作
     */
    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        // temp用来标记制作每束花中剩余的花朵数量
        int temp = k;
        // 遍历花园中的开花天数
        for (int i : bloomDay) {
            // 当前这朵花开花了
            if (i < day) {
                temp--;
                // 满足制作一束花的条件
                if (temp == 0) {
                    m--;
                    temp = k;
                }
            } else {
                // 当前这朵花没有开花
                // 也就是k朵花不连续, 重置temp
                temp = k;
            }
        }
        // 如果m束花全部完成制作, 返回true, 否则false.
        return m <= 0;
    }
}
