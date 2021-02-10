/**
 * Description:
 * <p>
 * Violence search
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] != A[j]) {
                    res++;
                }

            }
        }

        return res;
    }
}
