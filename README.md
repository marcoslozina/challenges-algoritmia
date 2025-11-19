# Challenges Algoritmia

Este repositorio contiene soluciones optimizadas en Java para 16 problemas de algoritmia de LeetCode.

## Estructura

Cada problema está en un archivo Java separado con:
- Descripción del problema
- Explicación del enfoque de solución
- Complejidad temporal y espacial (Big O)
- Método `main` con tests unitarios

## Problemas incluidos

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

