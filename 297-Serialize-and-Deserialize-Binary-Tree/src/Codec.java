import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 前序遍历解决二叉树序列化
 * 1, 2, 3, 4, 5, 6
 * ｜
 * root
 * <p>
 * Created By xxm
 */
public class Codec {

    /**
     * 前序遍历系列化帮助函数
     */
    private void helpSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }

        sb.append(root.val).append(",");

        helpSerialize(root.left, sb);
        helpSerialize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpSerialize(root, sb);
        return sb.toString();
    }

    /**
     * 前序遍历反序列化帮助函数
     */
    private TreeNode helpDeserialize(LinkedList<String> data) {
        if (data.isEmpty()) return null;

        String first = data.removeFirst();
        if (first.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = helpDeserialize(data);
        root.right = helpDeserialize(data);

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

        Codec ser = new Codec();
        String serialize = ser.serialize(root);
        System.out.println(serialize);

        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        Codec serRes = new Codec();
        System.out.println(serRes.serialize(ans));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
