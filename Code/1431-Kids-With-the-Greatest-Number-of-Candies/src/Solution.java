import java.util.ArrayList;
import java.util.List;

/**
 * Description: 简单贪心
 * Created By xxm
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 统计拥有最多的糖果数目
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        // 将额外的糖果全部分给每个孩子, 看他们的糖果数目是否超过拥有最多糖果数目
        List<Boolean> ans = new ArrayList<>();
        for (int candy : candies) {
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }
}
