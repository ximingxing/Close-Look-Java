import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 累加员工重要度, 员工组织结构可抽象为树形结构
 * Solution: 深度优先搜索
 * Created By xxm
 */
public class Solution2 {
    int ans;
    Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        // 将 employees 存入 HashMap;
        // 键: id, 值: Employee
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        ans = 0;
        return dfs(id);
    }

    /* 深度优先搜索 */
    private int dfs(int id) {
        Employee employee = map.get(id);
        ans += employee.importance;

        for (Integer subordinate : employee.subordinates) {
            dfs(subordinate);
        }

        return ans;
    }
}
