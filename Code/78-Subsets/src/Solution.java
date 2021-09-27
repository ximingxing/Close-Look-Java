import java.util.LinkedList;
import java.util.List;

/**
 * Description: 求数组中所有元素的子集
 * Solution: 回溯
 * Created By xingximing.xxm
 */
public class Solution {

    List<List<Integer>> res;

    private void backtrace(int[] nums, int start, LinkedList<Integer> path) {
        res.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, i + 1, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        backtrace(nums, 0, new LinkedList<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
