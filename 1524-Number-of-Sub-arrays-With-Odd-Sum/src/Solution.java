/**
 * Description:
 * <p>
 * 前缀和+组合计数
 * <p>
 * Created By xxm
 */
public class Solution {
    public int numOfSubarrays(int[] arr) {
        //
        final int MODULO = 1000000007;
        //
        int odd = 0, even = 1;
        int subArrays = 0;
        int sum = 0;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subArrays = (subArrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subArrays;
    }
}
