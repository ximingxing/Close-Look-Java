import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * <p>
 * 层序遍历
 * <p>
 * Created By xxm
 */
public class Codec3 {

    // Encodes a tree to a single string.
    // 层序遍历二叉树
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) {
                sb.append("#").append(",");
                continue;
            }
            sb.append(cur.val).append(",");

            // 这里我们需要null的信息, 所以不判断空
            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        // 用队列保存每一层的节点
        Queue<TreeNode> q = new LinkedList<>();

        String[] strings = data.split(",");
        String first = strings[0];
        if (first.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        // 让根节点先入队
        q.offer(root);

        // 从i=1开始遍历string
        for (int i = 1; i < strings.length; ) {
            // 队列中存的都是父节点
            TreeNode cur = q.poll();

            // 父节点对应的左侧子节点的值
            String left = strings[i++];
            if (!left.equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(left));
                q.offer(cur.left);
            } else {
                cur.left = null;
            }

            // 父节点对应的左侧子节点的值
            String right = strings[i++];
            if (!right.equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(right));
                q.offer(cur.right);
            } else {
                cur.right = null;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);

        Codec3 ser = new Codec3();
        String serialize = ser.serialize(root);
        System.out.println(serialize);

        Codec3 deser = new Codec3();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        Codec3 serRes = new Codec3();
        System.out.println(serRes.serialize(ans));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
