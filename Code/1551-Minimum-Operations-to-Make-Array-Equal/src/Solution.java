/**
 * Description:
 * <p>
 * Example:
 * Input: n = 3
 * Output: 2
 * Explanation: arr = [1, 3, 5]
 * First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
 * In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
 * <p>
 * Created By xxm
 */

// See README.md about details.
public class Solution {
    public int minOperations(int n) {
        return (n * n - (n & 1)) >> 2;
    }
}
