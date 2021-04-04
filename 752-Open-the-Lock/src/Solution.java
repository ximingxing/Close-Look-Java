import java.util.*;

/**
 * Description:
 * <p>
 * 将旋转密码锁可能性看作多叉树的遍历;
 * 该问题转变为求多叉树最低高度.
 * <p>
 * Created By xxm
 */
public class Solution {

    /* 在 i 位置向上转动一下密码锁 */
    private String upWheels(String code, int i) {
        char[] chars = code.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i]++;
        }
        return new String(chars);
    }

    /* 在 i 位置向下转动一下密码锁 */
    private String downWheels(String code, int i) {
        char[] chars = code.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i]--;
        }
        return new String(chars);
    }

    public int openLock(String[] deadends, String target) {
        // 记录死亡密码
        Set<String> deadNum = new HashSet<>(Arrays.asList(deadends));
        // 记录出现过的密码
        Set<String> have = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        // 初始状态
        q.add("0000");
        have.add("0000");
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                // 当前密码等于 target, 返回最小转动次数
                if (cur.equals(target)) {
                    return res;
                }
                // 如果当前密码出现在 deadNum, 跳过
                if (deadNum.contains(cur)) {
                    continue;
                }

                // 转动密码锁
                for (int j = 0; j < 4; j++) {
                    String upWheels = upWheels(cur, j);
                    if (!have.contains(upWheels)) {
                        q.offer(upWheels);
                        have.add(upWheels);
                    }
                    String downWheels = downWheels(cur, j);
                    if (!have.contains(downWheels)) {
                        q.offer(downWheels);
                        have.add(downWheels);
                    }
                }
            }
            // 最小树高度加一
            res++;
        }

        // 无法旋转到目标数字且不被锁定
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(new Solution().openLock(deadends, "0202"));

        String[] deadends2 = new String[]{"8888"};
        System.out.println(new Solution().openLock(deadends2, "0009"));

        String[] deadends3 = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(new Solution().openLock(deadends3, "8888"));

        String[] deadends4 = new String[]{"0000"};
        System.out.println(new Solution().openLock(deadends4, "8888"));
    }
}
