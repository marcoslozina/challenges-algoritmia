import java.util.*;

/**
 * LeetCode 71 - Simplify Path
 * 
 * Link: https://leetcode.com/problems/simplify-path/
 * 
 * Problem Description:
 * Given a string path, which is an absolute path (starting with a '/') to a file or
 * directory in a Unix-style file system, convert it to the simplified canonical path.
 * 
 * In a Unix-style file system, a period '.' refers to the current directory, a double
 * period '..' refers to the directory up a level, and any multiple consecutive slashes
 * (i.e. '//') are treated as a single slash '/'.
 * 
 * Example:
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * 
 * Solution Approach:
 * 1. Split path by '/' and process each part
 * 2. Use a stack (Deque) to maintain current path:
 *    - If we find "..", remove last directory (if exists)
 *    - If we find "." or "", ignore it
 *    - Any other string, add to stack
 * 3. Build final path from stack, adding "/" between directories
 * 4. If stack is empty, return "/"
 * 
 * Time Complexity: O(n) where n is the path length
 * Space Complexity: O(n)
 */
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }
        
        return result.toString();
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 71 - Simplify Path ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String path1 = "/home/";
        String result1 = sol.simplifyPath(path1);
        assert result1.equals("/home") : "Test 1 failed: expected /home, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Con puntos
        String path2 = "/../";
        String result2 = sol.simplifyPath(path2);
        assert result2.equals("/") : "Test 2 failed: expected /, got " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Ruta compleja
        String path3 = "/home//foo/";
        String result3 = sol.simplifyPath(path3);
        assert result3.equals("/home/foo") : "Test 3 failed: expected /home/foo, got " + result3;
        System.out.println("✓ Test 3 passed: " + result3);
        
        // Test 4: Con doble punto
        String path4 = "/a/./b/../../c/";
        String result4 = sol.simplifyPath(path4);
        assert result4.equals("/c") : "Test 4 failed: expected /c, got " + result4;
        System.out.println("✓ Test 4 passed: " + result4);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

