# Resumen de Semana 6: Programación Dinámica (Básica)

## 📌 Estructuras y Patrones

### 1️⃣ DP Mono-Dimensional (`1D Array` O Variables de Memoria)
- **Patrón principal:** Maximizar o minimizar métricas a partir de subproblemas (Ej: `House Robber`, `Climbing Stairs`, `Coin Change`), Optimización Local, `Kadane's Algorithm`.
- **Idea Clave:** Muchos problemas no exigen repasar o rehacer el viaje completo para descubrir la mejor solución si ya calculaste los casos `[i-1]` o `[i-2]`. Se basan en decisiones tomadas a medida que se iteran pasos únicos (¿Mejoro el valor o evado el costo tomando el valor `i` más un valor previo base?).
- **Cómo resolverlo con Java:** Con un array que tenga un registro (Tabulación "Bottom-Up"): `int[] dp = new int[n+1]; dp[0] = 0; dp[1] = nums[0];`. O con dos variables si la memoria necesaria es limitada a "Casos Seguidos" usando `prev1 = Math.max(prev1, prev2 + nums[i])` en O(1) de espacio.

### 2️⃣ DP Avanzado sobre Cadenas (Substrings y Palíndromos)
- **Patrón principal:** Matriz de comparaciones o Expansión desde Centros (`Longest Palindromic Substring`).
- **Idea Clave:** Relacionar y reciclar información ya comparada de las "capas internas" en un String (P: "Si los caracteres de los extremos coinciden, y la cadena del medio ya fue evaluada como un palíndromo, ¡toda la cadena es un palíndromo!").
- **Cómo resolverlo en Java:** Evaluando el estado progresivo de la cadena hacia afuera validando en $O(N^2)$ (ej: `left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)`).

---

## ⚠️ Errores Comunes a Evitar

1. **Variables Sin Reciclar (Espacio innecesario `O(N)`)**:
   - ❌ Es un error normal plantear DP con un vector de memoria gigante cuando solo dependes del "pasado inmediato" o el "penúltimo pasado".
   - ✅ En Fibonacci/HouseRobber/ClimbingStairs (problemas que solo relacionan la iteración anterior y la anterior-anterior), descarta el vector de variables array y cámbialas por dos de tipo simples: `prev1` y `prev2`.

2. **Error al Inicializar la Estructura (Edge Cases Iniciales `dp[0], dp[1]`)**:
   - ❌ Omitir rellenar los datos de inicio (base cases de DP). Si `n=1`, fallaría un `dp[1] = ...` si creaste un array `dp = new int[n];` y este por defecto es 0 o dará Index Out of Bounds si pones `[0]` sin validar.
   - ✅ Inicializa arrays como `dp = new int[n + 1]` para lidiar de una forma "humana y aritmética" con tamaños lógicamente contables, o pon if statements de chequeo inicial por casos sueltos (`n == 0 return 0`).

3. **Valores Centinela y Max/Mins Falsos**:
   - ❌ En "Coin Change" plantear el arreglo todo en ceros `0`, pero intentas que las combinaciones elijan lo más conveniente (Mínimo). `0` va a arruinar tu función min.
   - ✅ Rellena tu DP con el `Integer.MAX_VALUE`, pre-calculado para dar infinito, usando el `Arrays.fill(dp, Integer.MAX_VALUE)` menos el `dp[0]` inicial en el que tú no usas monedas. Al usar centinelas o IntegerMax prevén el Overflow si le sumas +1 al centinela.
