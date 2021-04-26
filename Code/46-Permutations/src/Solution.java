import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * <p>
 * 回溯算法求全排列
 * <p>
 * Created By xxm
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void backtrace(int[] nums, LinkedList<Integer> track) {
        // 找到一个合法全排列
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 选择
            track.addLast(nums[i]);
            // 递归继续选择下一个数字
            backtrace(nums, track);
            // 撤销选择
            track.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(nums, track);
        return ans;
    }
}
