# Challenges Algoritmia

Este repositorio contiene soluciones optimizadas en Java para problemas de algoritmia de LeetCode, organizadas según un plan de estudio de 6 semanas.

## Estructura

Cada problema está en un archivo Java separado con:
- Descripción del problema
- Explicación del enfoque de solución
- Complejidad temporal y espacial (Big O)
- Método `main` con tests unitarios

## Problemas incluidos

### Lista completa de problemas (ordenados por número de LeetCode):

#### Problemas Originales:

1. **3** - Longest Substring Without Repeating Characters
2. **5** - Longest Palindromic Substring
3. **20** - Valid Parentheses
4. **36** - Valid Sudoku
5. **49** - Group Anagrams
6. **53** - Maximum Subarray
7. **54** - Spiral Matrix
8. **56** - Merge Intervals
9. **57** - Insert Interval
10. **68** - Text Justification
11. **70** - Climbing Stairs
12. **71** - Simplify Path
13. **76** - Minimum Window Substring
14. **84** - Largest Rectangle in Histogram
15. **101** - Symmetric Tree
16. **104** - Maximum Depth of Binary Tree
17. **128** - Longest Consecutive Sequence
18. **146** - LRU Cache
19. **150** - Evaluate Reverse Polish Notation
20. **155** - Min Stack
21. **198** - House Robber
22. **202** - Happy Number
23. **205** - Isomorphic Strings
24. **226** - Invert Binary Tree
25. **232** - Implement Queue using Stacks
26. **236** - Lowest Common Ancestor of a Binary Tree
27. **239** - Sliding Window Maximum
28. **322** - Coin Change
29. **332** - Reconstruct Itinerary
30. **347** - Top K Frequent Elements
31. **543** - Diameter of Binary Tree
32. **723** - Candy Crush
33. **739** - Daily Temperatures
34. **1861** - Rotating the Box
35. **2043** - Simple Bank System
36. **2672** - Number of Adjacent Elements With the Same Color
37. **2768** - Number of Black Blocks
38. **3034** - Number of Subarrays That Match a Pattern I
39. **3045** - Count Prefix and Suffix Pairs II
40. **3071** - Minimum Operations to Write the Letter Y on a Grid
41. **3161** - Block Placement Queries

**Total: 41 problemas resueltos**


## 🧠 Plan de Estudio de Algoritmia – 6 Semanas

### ✅ Semana 1: Arrays y Strings (básicos)

**Objetivo:** Familiarizarse con manipulación de arrays, strings y operaciones básicas.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| ContainsDuplicate | ☑️ Completado | HashSet + Arrays |
| ReverseString | ☑️ Completado | Punteros |
| TwoSum | ☑️ Completado | HashMap + búsqueda |
| ValidAnagram | ☑️ Completado | HashMap / Array de chars |
| BinarySearchNumerosPares | ☑️ Completado | Búsqueda binaria |
| DetectarPrimerCaracterDuplicado | ☑️ Completado | HashSet + recorrido |
| Palindromo | ☑️ Completado | Punteros + lógica |
| ParentesisBalanceados | ☑️ Completado | Stack |

### ✅ Semana 2: HashMap y Sets

**Objetivo:** Profundizar en estructuras clave para búsquedas y conteos eficientes.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| 49 - Group Anagrams | ☑️ Completado | HashMap con listas |
| 347 - Top K Frequent Elements | ☑️ Completado | HashMap + PriorityQueue |
| 36 - Valid Sudoku | ☑️ Completado | Validación con Set |
| 202 - Happy Number | ☑️ Completado | Detección de ciclos con Set |
| 205 - Isomorphic Strings | ☑️ Completado | HashMap + bi-mapeo |
| 128 - Longest Consecutive Sequence | ☑️ Completado | Set + optimización |

### ✅ Semana 3: Pilas y Colas

**Objetivo:** Aprender uso de estructuras LIFO/FIFO para problemas secuenciales.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| 155 - Min Stack | ☑️ Completado | Stack con estado |
| 20 - Valid Parentheses | ☑️ Completado | Stack |
| 739 - Daily Temperatures | ☑️ Completado | Stack + índices |
| 232 - Implement Queue using Stacks | ☑️ Completado | Stack/Queue sim |
| 150 - Evaluate Reverse Polish Notation | ☑️ Completado | Stack matemática |

### ✅ Semana 4: Árboles y Recursión

**Objetivo:** Entender estructuras jerárquicas y recursividad.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| 104 - Maximum Depth of Binary Tree | ☑️ Completado | DFS recursivo |
| 226 - Invert Binary Tree | ☑️ Completado | Recursión |
| 543 - Diameter of Binary Tree | ☑️ Completado | Recursión con estado |
| 236 - Lowest Common Ancestor | ☑️ Completado | Recursión |
| 101 - Symmetric Tree | ☑️ Completado | Recursión + mirror |

### ✅ Semana 5: Sorting & Sliding Window

**Objetivo:** Aplicar ventanas móviles y técnicas de ordenamiento.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| 56 - Merge Intervals | ☑️ Completado | Sorting |
| 57 - Insert Interval | ☑️ Completado | Sorting + lógica |
| 239 - Sliding Window Maximum | ☑️ Completado | Deque + ventana |
| 3 - Longest Substring Without Repeating Characters | ☑️ Completado | Sliding window + Set |
| 76 - Minimum Window Substring | ☑️ Completado | Sliding window + Map |

### ✅ Semana 6: Programación Dinámica (DP) Básica

**Objetivo:** Introducción a subproblemas y memoización/tabulación.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| 70 - Climbing Stairs | ☑️ Completado | DP básico (Fibonacci) |
| 198 - House Robber | ☑️ Completado | DP 1D |
| 322 - Coin Change | ☑️ Completado | DP con mínimos |
| 5 - Longest Palindromic Substring | ☑️ Completado | DP + strings |
| 53 - Maximum Subarray | ☑️ Completado | Kadane's Algorithm |

## Ejecución

### Ejecutar un problema individual

```bash
# Compilar
javac nombre_archivo.java

# Ejecutar (con tests)
java NombreClase
```

Ejemplo:
```bash
javac 2043_simple_bank_system.java
java Bank
```

### Ejecutar todos los tests

```bash
./run_all_tests.sh
```

O manualmente:
```bash
bash run_all_tests.sh
```

## Requisitos

- Java JDK 8 o superior
- Compilador `javac`
- Intérprete `java`

## Notas

- Todos los archivos incluyen tests unitarios en el método `main`
- Las soluciones están optimizadas para la mejor complejidad Big O posible
- Los tests usan `assert` - ejecutar con `java -ea NombreClase` para habilitar assertions

