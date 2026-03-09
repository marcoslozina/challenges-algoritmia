# Resumen de Semana 1: Arrays y Strings (Básico)

## 📌 Estructuras y Patrones

### 1️⃣ Array (`int[]`, `char[]`, `String[]`)
- **Patrón principal:** Secuencias estáticas, Punteros múltiples (Two Pointers), Ventana Deslizante (Sliding Window).
- **Idea Clave:** Estructura de memoria contigua y tamaño fijo. Es la base de algoritmos que requieren acceso rápido por índice en `O(1)`.
- **Cómo resolverlo con Java:** Si conoces el tamaño exacto usa `new int[N]`. Utiliza el `for(int i)` tradicional cuando necesites manipular los índices o compararlos, o `for(int n : arr)` si solo vas a leer. Usa punteros lógicos (`left`, `right`) para recorrer desde extremos.

### 2️⃣ String
- **Patrón principal:** Procesamiento de texto, Palíndromos, Anagramas, Ventanas Deslizantes.
- **Idea Clave:** En Java, los `String` son INMUTABLES. Cada concatenación (`+`) produce un nuevo objeto. Usar `StringBuilder` si debes modificar o armar textos en bucles.
- **Cómo resolverlo con Java:** Para evitar costos, no intentes modificar caracteres in-place, convierte en un arreglo manipulable con `s.toCharArray()`. O itera validando con `s.charAt(i)`.

### 3️⃣ char
- **Patrón principal:** Mapeo a índices (Frequency Array / ASCII), Validaciones específicas de texto clásico.
- **Idea Clave:** Secretamente un `char` es tratado numéricamente como su valor de código ASCII. Por tanto, puedes hacer sumas y restas sobre ellos para calcular desfases lógicos.
- **Cómo resolverlo con Java:** Para arreglos de frecuencia contigua, calcula el índice restándole el primer carácter: `int index = c - 'a'`. Usa comodidades nativas como `Character.isDigit()` o `Character.isLetter()`.

### 4️⃣ int (trucos frecuentes)
- **Patrón principal:** Manipulación de dígitos, Evitar desbordamiento (Overflow).
- **Idea Clave:** Comprender el peso de la base 10: el módulo `% 10` desprende el último dígito, la división entera `/ 10` remueve dicho último dígito.
- **Ejemplo en Java:** `12 % 10 = 2` y `12 / 10 = 1`.

---

## ⚠️ Errores Comunes a Evitar

1. **`length` vs `length()`**:
   - Para arreglos: `nums.length` (NO lleva paréntesis porque es una propiedad).
   - Para Strings: `cadena.length()` (SÍ lleva paréntesis porque es un método).

2. **Comillas simples vs dobles**:
   - `String`: **SIEMPRE** comillas dobles `"Una cadena"`.
   - `char`: **SIEMPRE** comillas simples `'v'`. Si usas dobles para un char o simples para más de una letra, da error de compilación.

3. **Comparar `String` con `char`**:
   - ❌ `if (word == '+')` (No puedes comparar un `String` con un primitivo `char`).
   - ✅ `if (word.equals("+"))`

4. **Comparación de Textos**:
   - ❌ `if (s == t)` (Compara referencias de memoria, ¡no uses esto para contenido!).
   - ✅ `if (s.equals(t))` (Compara el contenido de los Strings).
