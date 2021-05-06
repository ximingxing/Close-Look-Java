import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 累加员工重要度, 员工组织结构可抽象为树形结构
 * Solution: 广度优先搜索
 * Created By xxm
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // 用于累加员工重要度
        int ans = 0;

        // 将 employees 存入 HashMap;
        // 键: id, 值: Employee
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Employee> q = new LinkedList<>();
        // 将目标员工压入队
        q.offer(map.get(id));
        // 累加队列中员工重要度
        while (!q.isEmpty()) {
            Employee employee = q.poll();
            ans += employee.importance;
            // 不断将目标员工的下属入队
            for (Integer subordinateId : employee.subordinates) {
                q.offer(map.get(subordinateId));
            }
        }

        return ans;
    }
}
