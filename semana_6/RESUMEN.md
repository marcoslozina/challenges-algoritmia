# Resumen de Semana 6: Programación Dinámica (Básica)

## 📌 Estructuras y Patrones

### 1️⃣ Programación Dinámica (DP) Mono-Dimensional (`1D Array` O Variables de Memoria)
- **Patrón principal:** Maximizar o minimizar métricas a partir de subproblemas (Ej: `House Robber`, `Climbing Stairs`, `Coin Change`), Optimización Local, `Kadane's Algorithm`.
- **Idea Clave:** Muchos problemas no exigen repasar o rehacer el viaje completo para descubrir la mejor solución si ya calculaste los casos `[i-1]` o `[i-2]`. Se basan en decisiones tomadas a medida que se iteran pasos únicos (¿Mejoro el valor o evado el costo tomando el valor `i` más un valor previo base?).
- **Cómo resolverlo con Java:** Con un array que tenga un registro (Tabulación "Bottom-Up"): `int[] dp = new int[n+1]; dp[0] = 0; dp[1] = nums[0];`. O con dos variables si la memoria necesaria es limitada a "Casos Seguidos" usando `prev1 = Math.max(prev1, prev2 + nums[i])` en O(1) de espacio.
- **⚠️ Errores Comunes:**
  - **Variables Sin Reciclar (Espacio innecesario `O(N)`)**: ❌ Plantear un vector gigante de memoria cuando solo dependes del "pasado inmediato" o "penúltimo pasado". ✅ En algortimos como HouseRobber o ClimbingStairs descarta el array y usa `prev1`/`prev2` para lograr espacio $O(1)$.
  - **Error al Inicializar Casos Base (`dp[0], dp[1]`)**: ❌ Omitir rellenar datos de inicio previendo `ArrayOutOfBoundsException`. ✅ Inicializar `new int[n + 1]` para dar respiro o casos de verificación sueltos al inicio como `if (n==0) return 0;`.
  - **Mínimos Falsos (Problema Coin Change)**: ❌ Dejar tu base en `0` que corrompe lógicas de mínimo `Math.min()`. ✅ Rellena con `Integer.MAX_VALUE`, pre-calculado para dar infinito, menos el paso inicial estricto de tú problema. ¡Recuerda el Overflow si sumas infinito con `+1`!

### 2️⃣ Programación Dinámica (DP) Avanzada sobre Cadenas (Substrings y Palíndromos)
- **Patrón principal:** Matriz de comparaciones o Expansión desde Centros (`Longest Palindromic Substring`).
- **Idea Clave:** Relacionar y reciclar información ya comparada de las "capas internas" en un String (P: "Si los caracteres de los extremos coinciden, y la cadena del medio ya fue evaluada como un palíndromo, ¡toda la cadena es un palíndromo!").
- **Cómo resolverlo en Java:** Evaluando el estado progresivo de la cadena hacia afuera validando en $O(N^2)$ (ej: `left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)`).
- **⚠️ Errores Comunes:**
  - **Expansión fuera del String**: ❌ Intentar leer `s.charAt(right)` permitiendo al índice llegar a `s.length()`. ✅ En los bulces de expansión es obligatorio colocar la cota corta-fuego: `while(left >= 0 && right < s.length())`.
