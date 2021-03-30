/**
 * Description:
 * <p>
 * 先递归遍历二分搜索树, 在根据三种情况删除节点
 * <p>
 * Created By xxm
 */
public class Solution {
    private TreeNode getMin(TreeNode node) {
        // BST最左边的节点元素值最小
        for (; node.left != null; node = node.left) ;
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // 找到需要删除的元素
        if (root.val == key) {
            // case1: 如果要删除的节点无孩子
            // case2: 如果要删除的节点仅有一个孩子
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // case3: 如果要删除的节点有两个孩子
            // 找到右子树中最小的孩子, 代替自己(拷贝存储的值), 转而去删除右子树中最小的节点.
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
