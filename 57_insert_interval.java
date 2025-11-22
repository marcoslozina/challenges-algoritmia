import java.util.*;

/**
 * 57 - Insert Interval
 * 
 * Descripción del problema:
 * Dado un array de intervalos no solapados ordenados por inicio, y un nuevo intervalo,
 * insertar y fusionar el nuevo intervalo en el array manteniendo el orden y sin solapamientos.
 * 
 * Enfoque de solución:
 * 1. Agregamos todos los intervalos que terminan antes del nuevo intervalo
 * 2. Fusionamos todos los intervalos que se solapan con el nuevo intervalo:
 *    - Actualizamos el inicio al mínimo
 *    - Actualizamos el fin al máximo
 * 3. Agregamos el intervalo fusionado
 * 4. Agregamos los intervalos restantes que no se solapan
 * 
 * Time Complexity: O(n) donde n es el número de intervalos
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

