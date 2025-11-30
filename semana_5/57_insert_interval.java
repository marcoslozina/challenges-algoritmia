import java.util.*;

/**
 * LeetCode 57 - Insert Interval
 * 
 * Link: https://leetcode.com/problems/insert-interval/
 * 
 * Problem Description:
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order
 * by starti. You are also given an interval newInterval = [start, end] that represents the start
 * and end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * 
 * Example:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Solution Approach:
 * 1. Add all intervals that end before the new interval
 * 2. Merge all intervals that overlap with the new interval:
 *    - Update start to minimum
 *    - Update end to maximum
 * 3. Add the merged interval
 * 4. Add remaining intervals that don't overlap
 * 
 * Time Complexity: O(n) where n is the number of intervals
 * Space Complexity: O(n)
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        // Agregar intervalos que terminan antes del nuevo intervalo
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Fusionar intervalos que se solapan con el nuevo intervalo
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Agregar intervalos restantes
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 57 - Insert Interval ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = sol.insert(intervals1, newInterval1);
        assert result1.length == 2 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: " + Arrays.deepToString(result1));
        
        // Test 2: Múltiples fusiones
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = sol.insert(intervals2, newInterval2);
        assert result2.length == 3 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: " + Arrays.deepToString(result2));
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

