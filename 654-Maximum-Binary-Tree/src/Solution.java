/**
 * Description:
 * Created By xxm
 */
public class Solution {

    private TreeNode recursive(int[] nums, int lo, int hi) {
        // 递归终止条件
        if (lo > hi) return null;

        // 在[lo, hi]区间内寻找作为root节点的最大值
        int max = Integer.MIN_VALUE;
        int ind = -1;
        for (int i = lo; i <= hi; i++) {
            if (max < nums[i]) {
                max = nums[i];
                ind = i;
            }
        }

        // 建立root
        TreeNode root = new TreeNode(max);

        // 分别对root的左右子树递归调用
        root.left = recursive(nums, lo, ind - 1);
        root.right = recursive(nums, ind + 1, hi);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }
}
