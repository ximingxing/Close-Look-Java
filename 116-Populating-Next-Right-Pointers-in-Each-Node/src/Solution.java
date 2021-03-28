/**
 * Description:
 * Created By xxm
 */
public class Solution {
    private void recursive(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;

        // 先为node1填充next域
        node1.next = node2;

        // 递归的遍历node1的左右子树
        recursive(node1.left, node1.right);
        // 递归的遍历node2的左右子树
        recursive(node2.left, node2.right);

        // 跨越父节点连接两个节点
        recursive(node1.right, node2.left);
    }

    public Node connect(Node root) {
        if (root == null) return null;
        recursive(root.left, root.right);
        return root;
    }
}
