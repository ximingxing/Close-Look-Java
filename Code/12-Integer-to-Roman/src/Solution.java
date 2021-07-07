
/**
 * Description: 数字转罗马数字
 * Solution: 贪心, 从最大的数字开始转换
 * Created By xingximing.xxm
 */
public class Solution {

    public String intToRoman(int num) {
        // int到roman的映射
        int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder roman = new StringBuilder();
        // 贪心策略: 从大到小开始转换
        for (int r = values.length - 1; r >= 0; r--) {
            while (num >= values[r]) {
                num -= values[r];
                roman.append(romans[r]);
            }
            if (num == 0) break;
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
    }
}
