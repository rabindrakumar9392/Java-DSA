import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    public int minimumTotal(List<List<Integer>> triangle) {
        return walk(triangle, 0, 0);
    }
    private int walk(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        String key = row + "," + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int left = walk(triangle, row + 1, col);
        int right = walk(triangle, row + 1, col + 1);
        int result = triangle.get(row).get(col) + Math.min(left, right);
        memo.put(key, result);
        return result;
    }
}
