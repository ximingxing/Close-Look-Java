/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public int numRabbits(int[] answers) {
        // 用于记录不同颜色兔子数量
        int[] record = new int[1000];
        int res = 0;
        // 依次遍历兔子
        for (int answer : answers) {
            // 如果已经遇到回答相同的兔子, 再次遇到就将数量减一
            if (record[answer] > 0) {
                record[answer]--;
            } else {
                // 当遇到新的兔子
                // 或者从前遇到的兔子数目减小为0
                record[answer] = answer;
                // 统计将他们回答的数量加上他们自己
                res += answer + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        int res = new Solution().numRabbits(arr);
        System.out.println("---");
        System.out.println(res);

        System.out.println("---");

        int[] arr2 = new int[]{10, 10, 10};
        int res2 = new Solution().numRabbits(arr2);
        System.out.println("---");
        System.out.println(res2);
    }
}
