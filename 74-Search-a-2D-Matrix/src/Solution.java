/**
 * Description:
 * <p>
 * 暴力搜索
 * <p>
 * Created By xxm
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) return true;
            }
        }
        return false;
    }
}
