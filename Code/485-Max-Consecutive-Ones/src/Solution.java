/**
 * Description: **一次遍历法**
 * <p>
 * 遇到1将count++, 否则count清零,
 * 统计数组中所有连续1的子串的长度,
 * 返回最大子串长度.
 * <p>
 * Created By xxm
 */
public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else count = 0;
            res = Math.max(count, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(a);
        System.out.println(maxConsecutiveOnes);
    }
}
