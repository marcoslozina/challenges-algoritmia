# Resumen de Semana 2: HashMap y Sets

## 📌 Estructuras y Patrones

### 1️⃣ HashMap (`Map<K, V>`)
- **Patrón principal:** Agrupaciones, Conteo de Frecuencias, Detección y emparejamiento usando complementos (ej: Two Sum).
- **Idea Clave:** Estructura superpoderosa para buscar, insertar y borrar en tiempo `O(1)`. Relaciona un par de `Clave -> Valor`.
- **Cómo resolverlo con Java:** Para contadores, el patrón estrella es `map.put(key, map.getOrDefault(key, 0) + 1)`. Para agrupar listas en un valor, usa el método moderno: `map.computeIfAbsent(key, k -> new ArrayList<>()).add(val)`.
- **⚠️ Errores Comunes:**
  - **Uso de Genéricos Incompatibles con Primitivos**: ❌ `Map<int, char>` (No compila). ✅ `Map<Integer, Character>` (Siempre debes usar Clases "Wrapper" en Java Collections).
  - **Acceso por un `get` nulo (NullPointerException)**: ❌ Incrementar una frecuencia sin revisar si la clave existe: `int value = map.get(k) + 1;` (Lanza error si no existe). ✅ Usar métodos seguros: `map.getOrDefault(k, 0) + 1;`

### 2️⃣ HashSet (`Set<T>`)
- **Patrón principal:** Existencia ultrarrápida (`O(1)`), Eliminación de duplicados, Detección de ciclos.
- **Idea Clave:** Garantiza que no existan repetidos y responde instantáneamente si un elemento ya fue procesado o visitado.
- **Cómo resolverlo con Java:** Usa `set.add(x)` para insertar (revisa el valor de retorno porque devuelve `false` si ya existía). Úsalo como un registro de elementos visitados para evitar ciclos infinitos en problemas como "Happy Number".
- **⚠️ Errores Comunes:**
  - **Ciclos Infinitos en Algoritmos de Detección**: ❌ (Ej: Happy Number) iterar infinitamente calculando sumas sin guardar estados pasados. ✅ Si aplicas el algoritmo y llegas a un valor recurrente antes que el 1, ¡es un ciclo! Validar con `set.contains()` siempre.

### 3️⃣ PriorityQueue (`Cola de Prioridad / Heap`)
- **Patrón principal:** Top 'K' elementos (ej. `Top K Frequent Elements`).
- **Idea Clave:** Mantiene ordenados los elementos según un Comparator a medida que se insertan. Extracción e inserción toman `O(log N)`.
- **Cómo resolverlo con Java:** Puedes armar colas referenciando pares `Map.Entry`:
  ```java
  PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
  // El lambda dicta que ordenará comparando el valor (value) de la entrada.
  ```
- **⚠️ Errores Comunes:**
  - **Sobreescritura ineficiente**: Añadir más elementos de `K` sobrecargará la cola perdiendo el rendimiento. Utiliza poll: `if (pq.size() > k) pq.poll();`.
