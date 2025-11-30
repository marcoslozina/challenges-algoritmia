import java.util.*;

/**
 * LeetCode 3161 - Block Placement Queries
 * 
 * Problem Description:
 * You are given an array queries where queries[i] = [typei, sizei, indexi].
 * 
 * There is a 0-indexed array nums of size n, initially all elements are 0.
 * 
 * For each query:
 * - If typei == 1: Place a block of size sizei at index indexi. The block must fit
 *   completely within the array (no part can be outside).
 * - If typei == 2: Remove the block at index indexi (if exists).
 * 
 * A block placement is valid if:
 * - The block fits completely within the array
 * - No part of the block overlaps with an existing block
 * 
 * Return an array result where result[i] is true if the ith query can be performed,
 * and false otherwise.
 * 
 * Solution Approach:
 * We maintain a sorted list of obstacles using binary search:
 * 1. To add obstacle: insert in order using binary search (O(log n))
 * 2. To query: find last obstacle before target position and verify if there's
 *    enough space for the block
 * 3. Use Collections.binarySearch to maintain sorted list efficiently
 * 
 * Time Complexity: O(n * log(n)) where n is the number of queries
 * Space Complexity: O(n)
 */
class Solution {
    public List<Boolean> getResults(int[][] queries) {
        List<Integer> obstacles = new ArrayList<>();
        obstacles.add(0); // Start with left boundary
        List<Boolean> result = new ArrayList<>();
        
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Add obstacle
                int pos = query[1];
                int idx = Collections.binarySearch(obstacles, pos);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                obstacles.add(idx, pos);
            } else {
                // Query
                int size = query[1];
                int targetIdx = query[2];
                
                // Binary search for the last obstacle before targetIdx
                int pos = Collections.binarySearch(obstacles, targetIdx);
                if (pos < 0) {
                    pos = -(pos + 1) - 1;
                } else {
                    pos--;
                }
                
                int lastObstacle = obstacles.get(pos);
                
                // Check if we can place block of size 'size' at position targetIdx
                if (targetIdx - lastObstacle >= size) {
                    result.add(true);
                } else {
                    // Check if we can place it before the last obstacle
                    if (pos > 0) {
                        int prevObstacle = obstacles.get(pos - 1);
                        if (targetIdx - prevObstacle >= size) {
                            result.add(true);
                        } else {
                            result.add(false);
                        }
                    } else {
                        result.add(false);
                    }
                }
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 3161 - Block Placement Queries ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] queries1 = {
            {1, 2}, {2, 3, 2}, {2, 3, 1}, {1, 5}, {2, 3, 2}
        };
        List<Boolean> result1 = sol.getResults(queries1);
        assert result1.size() == 3 : "Test 1.1 failed";
        assert result1.get(0) == true : "Test 1.2 failed";
        assert result1.get(1) == false : "Test 1.3 failed";
        assert result1.get(2) == true : "Test 1.4 failed";
        System.out.println("✓ Test 1 passed: Caso básico");
        
        // Test 2: Sin obstáculos
        int[][] queries2 = {
            {2, 3, 2}, {2, 3, 1}
        };
        List<Boolean> result2 = sol.getResults(queries2);
        assert result2.get(0) == true : "Test 2.1 failed";
        assert result2.get(1) == true : "Test 2.2 failed";
        System.out.println("✓ Test 2 passed: Sin obstáculos");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

