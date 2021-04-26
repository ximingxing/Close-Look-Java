/**
 * Description:
 * Created By xxm
 */
public class Solution {

    public boolean isUgly(int n) {
        // n小于等于0不满足丑数定义
        if (n <= 0) return false;
        // 因数集合
        int[] factors = new int[]{2, 3, 5};

        // 让n不断整除因数集合中的因数, 直到无法整除为止
        // 即直到n中不再包含2、3、5, 说明n是丑数
        // 否则n中包含其他质因数, n不是丑数
        for (int f : factors) {
            while (n % f == 0)
                n /= f;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(8));
    }
}
