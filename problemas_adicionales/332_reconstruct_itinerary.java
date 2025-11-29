import java.util.*;

/**
 * 332 - Reconstruct Itinerary
 * 
 * Descripción del problema:
 * Dada una lista de tickets de avión [from, to], reconstruir el itinerario en orden.
 * Todos los tickets deben usarse exactamente una vez. Si hay múltiples itinerarios
 * válidos, devolver el lexicográficamente menor. El viaje siempre comienza en "JFK".
 * 
 * Enfoque de solución:
 * Usamos DFS (Depth-First Search) con ordenamiento lexicográfico:
 * 1. Construimos un grafo dirigido: Map<String, PriorityQueue<String>>
 *    - PriorityQueue asegura que siempre elegimos el destino lexicográficamente menor
 * 2. Realizamos DFS desde "JFK":
 *    - Visitamos todos los destinos del aeropuerto actual en orden lexicográfico
 *    - Usamos el ticket (removemos de la PriorityQueue) antes de hacer DFS recursivo
 * 3. Agregamos el aeropuerto actual al resultado después de procesar todos sus destinos
 * 4. Invertimos el resultado al final (porque agregamos en orden post-orden)
 * 
 * Este enfoque garantiza que usamos todos los tickets y encontramos el camino
 * lexicográficamente menor usando el algoritmo de Hierholzer.
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

