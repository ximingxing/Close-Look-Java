/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;

        // 当 left < right 时, 循环判断
        // 当 left = right 时, 说明是回文
        while (left < right) {
            // 如果当前 left 指向的字符不合法
            if (!(arr[left] >= 'A' && arr[left] <= 'Z'
                    || arr[left] >= 'a' && arr[left] <= 'z'
                    || arr[left] >= '0' && arr[left] <= '9')) {
                left++;
                continue;
            }
            // 如果当前 right 指向的字符不合法
            if (!(arr[right] >= 'A' && arr[right] <= 'Z'
                    || arr[right] >= 'a' && arr[right] <= 'z'
                    || arr[right] >= '0' && arr[right] <= '9')) {
                right--;
                continue;
            }
            // 当 left 和 right 指向的字符不同时, 说明不是回文
            if (arr[left] != arr[right]) return false;
            // 移动左右指针
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
//        String s = "aa";
        System.out.println(new Solution().isPalindrome(s));
    }
}
