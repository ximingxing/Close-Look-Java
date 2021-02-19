/**
 * Description:
 * <p>
 * 前缀和+组合计数
 * <p>
 * Created By xxm
 */
public class Solution {
    public int numOfSubarrays(int[] arr) {
        // 由于取和后答案可能会很大, 需要将结果对 10^9 + 7 取余后返回.
        final int MODULO = 1000000007;
        // 统计 奇数前缀和的数量 与 偶数前缀和的数量
        int odd = 0, even = 1;
        // 和为奇数的子数组数目
        int subArrays = 0;
        // 对数组arr求和
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // 统计i的位置的前缀和
            sum += arr[i];
            // 如果i的位置的前缀和是偶数, 且j(j < i)的位置前缀和为奇数, 则j+1到i的子数组和为奇数
            // 同理, 如果i的位置前缀和是奇数, 那么j(j < i)的位置的前缀和为偶数, 则j+1到i的子数组和为偶数
            subArrays = (subArrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            // 根据前缀和奇偶性更新odd和even
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subArrays;
    }
}
