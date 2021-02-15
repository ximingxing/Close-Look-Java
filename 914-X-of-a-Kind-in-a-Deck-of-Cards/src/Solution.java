import java.util.HashMap;

/**
 * Description: Euclidean algorithm
 * <p>
 * HashMap 计数
 * <p>
 * Created By xxm
 */
public class Solution {
    private static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        // 统计每种数字出现的次数
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : deck) {
            if (!count.containsKey(num)) count.put(num, 1);
            else count.put(num, count.get(num) + 1);
        }
        // 求每种数字出现次数的最大公约数
        int g = 0;
        for (Integer key : count.keySet()) {
            g = gcd(g, count.get(key));
            // 每种数字出现次数最大公约数为1, 即无法整分
            if (g == 1) return false;
        }
        return g >= 2;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(hasGroupsSizeX(a));
    }
}
