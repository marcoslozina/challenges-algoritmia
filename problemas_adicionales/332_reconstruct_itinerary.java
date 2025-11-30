import java.util.*;

/**
 * LeetCode 332 - Reconstruct Itinerary
 * 
 * Link: https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Problem Description:
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent
 * the departure and arrival airports of one flight. Reconstruct the itinerary in order
 * and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must
 * begin with "JFK". If there are multiple valid itineraries, you should return the
 * itinerary that has the smallest lexical order when read as a single string.
 * 
 * Example:
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * 
 * Solution Approach:
 * We use DFS (Depth-First Search) with lexicographic ordering:
 * 1. Build a directed graph: Map<String, PriorityQueue<String>>
 *    - PriorityQueue ensures we always choose lexicographically smallest destination
 * 2. Perform DFS from "JFK":
 *    - Visit all destinations of current airport in lexicographic order
 *    - Use ticket (remove from PriorityQueue) before recursive DFS
 * 3. Add current airport to result after processing all its destinations
 * 4. Reverse result at the end (because we add in post-order)
 * 
 * This approach guarantees we use all tickets and find the lexicographically smallest
 * path using Hierholzer's algorithm.
 * 
 * Time Complexity: O(E * log(E)) where E is the number of edges
 * Space Complexity: O(E)
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        
        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, graph, result);
        }
        
        result.add(airport);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 332 - Reconstruct Itinerary ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        List<List<String>> tickets1 = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );
        List<String> result1 = sol.findItinerary(tickets1);
        List<String> expected1 = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        assert result1.equals(expected1) : "Test 1 failed: " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Múltiples opciones
        List<List<String>> tickets2 = Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
        );
        List<String> result2 = sol.findItinerary(tickets2);
        List<String> expected2 = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        assert result2.equals(expected2) : "Test 2 failed: " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

