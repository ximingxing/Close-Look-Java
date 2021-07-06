/**
 * Description: 回文数
 * Solution: 双指针
 * Created By xxm
 */
public class Solution {
    public boolean isPalindrome(int x) {
        // int to char array
        char[] arr = String.valueOf(x).toCharArray();
        int len = arr.length;
        // two-pointer
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (arr[i] != arr[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
    }
}
