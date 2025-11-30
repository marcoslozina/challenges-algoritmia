import java.util.*;

/**
 * LeetCode 68 - Text Justification
 * 
 * Problem Description:
 * Given an array of strings words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you
 * can in each line. Pad extra spaces ' ' when necessary so that each line has exactly
 * maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number
 * of spaces on a line does not divide evenly between words, the empty slots on the left
 * will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left-justified, and no extra space is inserted
 * between words.
 * 
 * Solution Approach:
 * 1. Group words that fit in a line:
 *    - Calculate how many words fit considering spaces between them
 * 2. For each line:
 *    - If it's the last line or has one word: left justification
 *      (one word, one space, rest spaces at the end)
 *    - Otherwise: uniform space distribution:
 *      - Calculate base spaces between words
 *      - Calculate extra spaces distributed left to right
 * 3. Build each line by adding words and spaces according to distribution
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

