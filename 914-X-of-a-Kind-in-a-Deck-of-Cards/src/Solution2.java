import java.util.HashMap;

/**
 * Description: Euclidean algorithm
 * <p>
 * 数组计数并不判断非0元素
 * <p>
 * Created By xxm
 */
public class Solution2 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        // 统计每种数字出现的次数
        int count[] = new int[10000];
        for (int num : deck) {
            count[num]++;
        }
        // 求每种数字出现次数的最大公约数
        int g = 0;
        for (int x : count) {
            if (x > 0) {
                g = gcd(g, x);
                // 每种数字出现次数最大公约数为1, 即无法整分
                if (g == 1) return false;
            }
        }
        return g >= 2;
    }
}

