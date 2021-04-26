import java.util.Arrays;

/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        char[] arr = s.toCharArray();
        System.out.println("before reverse: " + Arrays.toString(arr));
        new Solution().reverseString(arr);
        System.out.println("after reverse: " + Arrays.toString(arr));
    }
}
