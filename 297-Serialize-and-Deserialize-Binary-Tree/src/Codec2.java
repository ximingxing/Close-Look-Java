import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 后序遍历解决二叉树序列化
 * 1, 2, 3, 4, 5, 6
 * |
 * root
 * <p>
 * Created By xxm
 */
public class Codec2 {

    /**
     * 后序遍历系列化帮助函数
     */
    private void helpSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }

        helpSerialize(root.left, sb);
        helpSerialize(root.right, sb);

        sb.append(root.val).append(",");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpSerialize(root, sb);
        return sb.toString();
    }

    /**
     * 后序遍历反序列化帮助函数
     */
    private TreeNode helpDeserialize(LinkedList<String> data) {
        if (data.isEmpty()) return null;

        String last = data.removeLast();
        if (last.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        root.right = helpDeserialize(data);
        root.left = helpDeserialize(data);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");

        LinkedList<String> strings = new LinkedList<>(Arrays.asList(split));

        return helpDeserialize(strings);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);

        Codec2 ser = new Codec2();
        String serialize = ser.serialize(root);
        System.out.println(serialize);

        Codec2 deser = new Codec2();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        Codec2 serRes = new Codec2();
        System.out.println(serRes.serialize(ans));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
