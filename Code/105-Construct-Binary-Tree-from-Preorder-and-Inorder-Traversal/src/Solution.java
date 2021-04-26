/**
 * Description:
 * Created By xxm
 */
public class Solution {
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        //
        if (preStart > preEnd) return null;

        // 二叉树前序遍历第一个节点是根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 在中序遍历([inStart, inEnd])中找到对应根节点对应的值
        // 即可将中序遍历分为左右子树区间
        int ind = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                ind = i;
                break;
            }
        }

        // 左子树的大小 = 中序遍历中根节点的索引 - 中序遍历起始索引
        int leftSize = ind - inStart;

        // 重点:
        // 前序遍历左子树: 起始索引 + 左子树大小
        // 前序遍历右子树: 起始索引 + 左子树大小 + 1
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, ind - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, ind + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }
}
