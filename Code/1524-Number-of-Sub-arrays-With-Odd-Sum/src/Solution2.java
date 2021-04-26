/**
 * Description:
 * <p>
 * 前缀和
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int numOfSubarrays(int[] arr) {
        int s[] = new int[]{1, 0};
        long res = 0;
        for (int i = 0, sum = 0; i < arr.length; i++) {
            // sum += arr[i];
            // ++s[sum % 2]
            //
            ++s[sum ^= arr[i] & 1];
            // res += s[1 - sum % 2]
            res += s[sum ^ 1];
        }
        return (int) (res % 1000000007);
    }
}
