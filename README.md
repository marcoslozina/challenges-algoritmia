# Challenges Algoritmia

Este repositorio contiene soluciones optimizadas en Java para problemas de algoritmia de LeetCode, organizadas según un plan de estudio de 6 semanas.

## Estructura

Cada problema está en un archivo Java separado con:
- Descripción del problema
- Explicación del enfoque de solución
- Complejidad temporal y espacial (Big O)
- Método `main` con tests unitarios

## Problemas incluidos

### Lista completa de problemas:

1. **2043** - Simple Bank System
2. **3161** - Block Placement Queries
3. **3045** - Count Prefix and Suffix Pairs II
4. **3071** - Minimum Operations to Write the Letter Y on a Grid
5. **2768** - Number of Black Blocks
6. **723** - Candy Crush
7. **84** - Largest Rectangle in Histogram
8. **2672** - Number of Adjacent Elements With the Same Color
9. **3034** - Number of Subarrays That Match a Pattern I
10. **1861** - Rotating the Box
11. **71** - Simplify Path
12. **56** - Merge Intervals
13. **146** - LRU Cache
14. **54** - Spiral Matrix
15. **68** - Text Justification
16. **332** - Reconstruct Itinerary

**Total: 16 problemas resueltos (originales)**

### Problemas adicionales del plan de estudio:

**Semana 2: HashMap y Sets (6 problemas)**
- 49 - Group Anagrams
- 347 - Top K Frequent Elements
- 36 - Valid Sudoku
- 202 - Happy Number
- 205 - Isomorphic Strings
- 128 - Longest Consecutive Sequence

**Semana 3: Pilas y Colas (5 problemas)**
- 155 - Min Stack
- 20 - Valid Parentheses
- 739 - Daily Temperatures
- 232 - Implement Queue using Stacks
- 150 - Evaluate Reverse Polish Notation

**Semana 4: Árboles y Recursión (5 problemas)**
- 104 - Maximum Depth of Binary Tree
- 226 - Invert Binary Tree
- 543 - Diameter of Binary Tree
- 236 - Lowest Common Ancestor
- 101 - Symmetric Tree

**Semana 5: Sorting & Sliding Window (4 problemas)**
- 57 - Insert Interval
- 239 - Sliding Window Maximum
- 3 - Longest Substring Without Repeating Characters
- 76 - Minimum Window Substring

**Semana 6: Programación Dinámica (5 problemas)**
- 70 - Climbing Stairs
- 198 - House Robber
- 322 - Coin Change
- 5 - Longest Palindromic Substring
- 53 - Maximum Subarray

**Total general: 41 problemas resueltos**

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

### 🟧 Semana 2: HashMap y Sets

**Objetivo:** Profundizar en estructuras clave para búsquedas y conteos eficientes.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| Group Anagrams | 🟧 Pendiente | HashMap con listas |
| Top K Frequent Elements | 🟧 Pendiente | HashMap + PriorityQueue |
| Valid Sudoku | 🟧 Pendiente | Validación con Set |
| Happy Number | 🟧 Pendiente | Detección de ciclos con Set |
| Isomorphic Strings | 🟧 Pendiente | HashMap + bi-mapeo |
| Longest Consecutive Sequence | 🟧 Pendiente | Set + optimización |

### 🍀 Semana 3: Pilas y Colas

**Objetivo:** Aprender uso de estructuras LIFO/FIFO para problemas secuenciales.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| Min Stack | 🟧 Pendiente | Stack con estado |
| Valid Parentheses | 🟧 Pendiente | Stack |
| Daily Temperatures | 🟧 Pendiente | Stack + índices |
| Implement Queue using Stacks | 🟧 Pendiente | Stack/Queue sim |
| Evaluate Reverse Polish Notation | 🟧 Pendiente | Stack matemática |

### 🌲 Semana 4: Árboles y Recursión

**Objetivo:** Entender estructuras jerárquicas y recursividad.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| Maximum Depth of Binary Tree | 🟧 Pendiente | DFS recursivo |
| Invert Binary Tree | 🟧 Pendiente | Recursión |
| Diameter of Binary Tree | 🟧 Pendiente | Recursión con estado |
| Lowest Common Ancestor | 🟧 Pendiente | Recursión |
| Symmetric Tree | 🟧 Pendiente | Recursión + mirror |

### 🔢 Semana 5: Sorting & Sliding Window

**Objetivo:** Aplicar ventanas móviles y técnicas de ordenamiento.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| Merge Intervals | ☑️ Completado | Sorting |
| Insert Interval | 🟧 Pendiente | Sorting + lógica |
| Sliding Window Maximum | 🟧 Pendiente | Deque + ventana |
| Longest Substring Without Repeat | 🟧 Pendiente | Sliding window + Set |
| Minimum Window Substring | 🟧 Pendiente | Sliding window + Map |

### 🧮 Semana 6: Programación Dinámica (DP) Básica

**Objetivo:** Introducción a subproblemas y memoización/tabulación.

| Ejercicio | Estado | Tema |
|-----------|--------|------|
| Climbing Stairs | 🟧 Pendiente | DP básico (Fibonacci) |
| House Robber | 🟧 Pendiente | DP 1D |
| Coin Change | 🟧 Pendiente | DP con mínimos |
| Longest Palindromic Substring | 🟧 Pendiente | DP + strings |
| Maximum Subarray | 🟧 Pendiente | Kadane's Algorithm |

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

