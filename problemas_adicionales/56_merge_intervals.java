import java.util.*;

/**
 * LeetCode 56 - Merge Intervals
 * 
 * Problem Description:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
 * intervals, and return an array of the non-overlapping intervals that cover all the
 * intervals in the input.
 * 
 * Example:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Solution Approach:
 * 1. Sort intervals by their start time (O(n log n))
 * 2. Iterate over sorted intervals:
 *    - If current interval overlaps with previous (start <= previous end),
 *      merge by updating end to maximum of both
 *    - If no overlap, add previous interval to result and start a new interval
 * 3. Add the last interval at the end
 * 
 * Key insight: After sorting, we only need to compare with the last interval in the
 * result, since all previous ones are already processed.
 * 
 * Time Complexity: O(n * log(n)) where n is the number of intervals
 * Space Complexity: O(n)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Non-overlapping, add current and start new
                merged.add(current);
                current = intervals[i];
            }
        }
        
        merged.add(current);
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 56 - Merge Intervals ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = sol.merge(intervals1);
        assert result1.length == 3 : "Test 1 failed: expected 3 intervals";
        System.out.println("✓ Test 1 passed: " + Arrays.deepToString(result1));
        
        // Test 2: Todos se solapan
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = sol.merge(intervals2);
        assert result2.length == 1 : "Test 2 failed: expected 1 interval";
        assert result2[0][0] == 1 && result2[0][1] == 5 : "Test 2 failed: wrong interval";
        System.out.println("✓ Test 2 passed: " + Arrays.deepToString(result2));
        
        // Test 3: Sin solapamiento
        int[][] intervals3 = {{1, 4}, {5, 6}};
        int[][] result3 = sol.merge(intervals3);
        assert result3.length == 2 : "Test 3 failed: expected 2 intervals";
        System.out.println("✓ Test 3 passed: " + Arrays.deepToString(result3));
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

