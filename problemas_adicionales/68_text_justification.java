import java.util.*;

/**
 * 68 - Text Justification
 * 
 * Descripción del problema:
 * Dado un array de palabras y un ancho máximo, justificar el texto de manera que:
 * - Cada línea tenga exactamente maxWidth caracteres
 * - Las palabras se distribuyan uniformemente con espacios extra
 * - La última línea (o línea con una sola palabra) se justifica a la izquierda
 * - Los espacios extra se distribuyen de manera uniforme, con más espacios a la izquierda
 * 
 * Enfoque de solución:
 * 1. Agrupamos palabras que caben en una línea:
 *    - Calculamos cuántas palabras caben considerando espacios entre ellas
 * 2. Para cada línea:
 *    - Si es la última línea o tiene una sola palabra: justificación izquierda
 *      (una palabra, un espacio, resto espacios al final)
 *    - Si no: distribución uniforme de espacios:
 *      - Calculamos espacios base entre palabras
 *      - Calculamos espacios extra que se distribuyen de izquierda a derecha
 * 3. Construimos cada línea agregando palabras y espacios según la distribución
 * 
 * Time Complexity: O(n) where n is the total number of characters
 * Space Complexity: O(n)
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int j = i;
            int lineLength = 0;
            
            // Find words that fit in current line
            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            int numWords = j - i;
            int numSpaces = maxWidth - lineLength;
            
            StringBuilder line = new StringBuilder();
            
            if (j == words.length || numWords == 1) {
                // Last line or single word: left justify
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                        numSpaces--;
                    }
                }
                // Add remaining spaces at the end
                while (numSpaces-- > 0) {
                    line.append(" ");
                }
            } else {
                // Distribute spaces evenly
                int spacesBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);
                
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spacesBetween + (extraSpaces > 0 ? 1 : 0);
                        extraSpaces--;
                        for (int s = 0; s < spacesToAdd; s++) {
                            line.append(" ");
                        }
                    }
                }
            }
            
            result.add(line.toString());
            i = j;
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 68 - Text Justification ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        List<String> result1 = sol.fullJustify(words1, maxWidth1);
        for (String line : result1) {
            assert line.length() == maxWidth1 : "Test 1 failed: line length incorrect";
        }
        System.out.println("✓ Test 1 passed: " + result1.size() + " líneas");
        
        // Test 2: Una palabra por línea
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        List<String> result2 = sol.fullJustify(words2, maxWidth2);
        for (String line : result2) {
            assert line.length() == maxWidth2 : "Test 2 failed: line length incorrect";
        }
        System.out.println("✓ Test 2 passed: " + result2.size() + " líneas");
        
        // Test 3: Palabras cortas
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        List<String> result3 = sol.fullJustify(words3, maxWidth3);
        for (String line : result3) {
            assert line.length() == maxWidth3 : "Test 3 failed: line length incorrect";
        }
        System.out.println("✓ Test 3 passed: " + result3.size() + " líneas");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

