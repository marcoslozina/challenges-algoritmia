

Entender algunas cosas sobre metodo

int [] nums = new int [3]; en un array como este, nums.length --> no lleva () porque length es una propiedad del array

String caden = new String; en un String cadena.length() si lleva por length es un metodo

En un string puedo usar commilla doble "La" "la cadena"  las commillas simples solo para un solo valor 'v' si uso commilla simple para mas de una letra da error

No se puede usar primirtivos con genericos, pj Map<int> Map<char> tiene que ser Map<Integer> Mar<Character>

En java la division por entero es 1 modulo % 10 = 1  y 1 / dividio 10 = 0 
 12 % 10 optiene el ultimo digito
 12 / 10 optiene l primer digito

 Hapy numero cuando separo ambos digitos y  elevo al cuadrado cada compoentne y repito esto y si llego a 1 es feliz si entra en un loop no



 🧠 Chuleta de Estructuras de Datos + Métodos más usados (Java)
1️⃣ Array (int[], char[], String[])
📌 Cuándo usar

Acceso por índice

Tamaño fijo

Recorrer secuencias

Sliding Window

Two Pointers

🔁 Recorridos típicos
for (int i = 0; i < arr.length; i++)
for (int num : arr)

🔧 Métodos / operaciones
arr.length
Arrays.sort(arr)
Arrays.toString(arr)

🔁 Casos típicos

Two Sum

Longest Consecutive Sequence

Sliding Window

Prefix Sum

---
💡 **Resumen de Sección (Array)**
- **Patrón principal:** Secuencias estáticas, Punteros múltiples (Two Pointers), Ventana Deslizante (Sliding Window).
- **Idea Clave:** Estructura de memoria contigua y tamaño fijo. Es la base de algoritmos que requieren acceso rápido por índice en O(1).
- **Cómo resolverlo con Java:** Si conoces el tamaño exacto usa `new int[N]`. Utiliza el `for(int i)` tradicional cuando necesites manipular los índices o compararlos, o `for(int n : arr)` si solo vas a leer. Usa punteros lógicos (variables tipo `left`, `right`) para recorrer desde extremos.

2️⃣ Matriz (int[][])
📌 Cuándo usar

Grillas

Mapas

BFS / DFS

Problemas 2D

🔁 Recorrido típico
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j];
    }
}

🔁 Direcciones comunes (BFS/DFS)
int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

🔁 Casos típicos

Number of Islands

Flood Fill

Rotting Oranges

---
💡 **Resumen de Sección (Matriz)**
- **Patrón principal:** Grillas (Grid), Búsqueda en grafos implícitos (BFS/DFS).
- **Idea Clave:** Representación 2D donde cada celda se ubica con `[fila][columna]`. Es vital validar siempre que no salgas de los límites `(fila >= 0 && fila < filas.length)`.
- **Cómo resolverlo con Java:** Itera con doble `for` anidado. Para simular movimientos ortogonales (arriba, abajo, izq, der) usa un array de desplazamientos `int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}` y calcula tu nueva posición sumándolo a la actual `nr = r + dir[0]`.

3️⃣ ArrayList<T>
📌 Cuándo usar

Lista dinámica

Agrupar resultados

Backtracking

🔧 Métodos clave
list.add(x)
list.get(i)
list.size()
list.remove(i)
list.clear()

🔁 Recorrido
for (int i = 0; i < list.size(); i++)
for (T x : list)

🔁 Casos típicos

Group Anagrams

Subsets

Permutations

---
💡 **Resumen de Sección (ArrayList)**
- **Patrón principal:** Colecciones dinámicas, Agrupamiento de resultados, Backtracking.
- **Idea Clave:** Es un arreglo subyacente que crece dinámicamente. Ideal cuando no sabes cuántos elementos guardarás antes de empezar.
- **Cómo resolverlo con Java:** Instancialo indicando el genérico `new ArrayList<>()`. Para Backtracking, agregas el elemento `list.add(x)`, haces el llamado recursivo, y luego lo remueves `list.remove(list.size() - 1)` para deshacer la decisión y probar el siguiente camino.

4️⃣ HashMap<K, V>
📌 Cuándo usar

Contar frecuencias

Mapping (clave → valor)

Cache / memoization

Detección de duplicados

🔧 Métodos MÁS IMPORTANTES (memorizar)
map.put(key, value)
map.get(key)
map.getOrDefault(key, 0)
map.containsKey(key)
map.putIfAbsent(key, new ArrayList<>())
map.remove(key)

🔥 Ultra clave (muchísimo en entrevistas)
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);

🔁 Recorrido
for (Map.Entry<K,V> e : map.entrySet())

🔁 Casos típicos

Two Sum

Group Anagrams

Isomorphic Strings

Frequency Count

---
💡 **Resumen de Sección (HashMap)**
- **Patrón principal:** Agrupaciones, Conteo de Frecuencias, Detección y emparejamiento usando complementos (ej: Two Sum).
- **Idea Clave:** Estructura superpoderosa para buscar, insertar y borrar en tiempo O(1). Relaciona pares de `Clave -> Valor`.
- **Cómo resolverlo con Java:** Para contadores, el patrón estrella es `map.put(key, map.getOrDefault(key, 0) + 1)`. Para agrupar listas o conjuntos en un valor, usa el método moderno: `map.computeIfAbsent(key, k -> new ArrayList<>()).add(val)`.

5️⃣ HashSet<T>
📌 Cuándo usar

Detectar duplicados

Ver si algo existe en O(1)

Evitar ciclos

🔧 Métodos clave
set.add(x)
set.contains(x)
set.remove(x)
set.size()

🔁 Casos típicos

Happy Number

Longest Consecutive Sequence

Detect Cycle

---
💡 **Resumen de Sección (HashSet)**
- **Patrón principal:** Existencia ultrarrápida (O(1)), Eliminación de duplicados, Detección de ciclos.
- **Idea Clave:** Garantiza que no existan repetidos y responde si un elemento ya fue procesado / visitado instantáneamente.
- **Cómo resolverlo con Java:** Usa `set.add(x)` para insertar (revisa el valor de retorno porque devuelve `false` si ya existía). Úsalo fundamentalmente como un registro de elementos `visitados` para no entrar en ciclos infinitos en problemas de grafos o el "Happy Number".

6️⃣ String
📌 Cuándo usar

Procesar caracteres

Anagramas

Palíndromos

🔧 Métodos CLAVE
s.length()
s.charAt(i)
s.toCharArray()
s.substring(a, b)
s.equals(other)

🔥 Comparaciones
s.equals(t)     // SIEMPRE
s == t          // ❌ NO

---
💡 **Resumen de Sección (String)**
- **Patrón principal:** Procesamiento de texto, Palíndromos, Anagramas, Ventanas Deslizantes.
- **Idea Clave:** En Java, los `String` son INMUTABLES. Cada concatenación (+) produce un nuevo objeto, lo que arriesga sobrecosto exponencial. Usar `StringBuilder` si debes modificar o armar textos en bucles.
- **Cómo resolverlo con Java:** Para evitar costos, no intentes modificar caracteres in-place, convierte en un arreglo manipulable con `s.toCharArray()`. O itera validando con `s.charAt(i)`. SIEMPRE compara contenido de textos utilizando `s.equals(other)`.

7️⃣ char
📌 Cuándo usar

Procesar letras

ASCII tricks

🔧 Operaciones comunes
char c = s.charAt(i);
c - 'a'        // índice 0–25
Character.isDigit(c)
Character.isLetter(c)

---
💡 **Resumen de Sección (char)**
- **Patrón principal:** Mapeo a índices (Frequency Array / ASCII), Validaciones específicas de texto clásico.
- **Idea Clave:** Secretamente un `char` es tratado numéricamente como su valor de código ASCII. Por tanto, puedes hacer sumas y restas sobre ellos para calcular desfases lógicos.
- **Cómo resolverlo con Java:** Para arreglos de frecuencia contigua, calcula el índice normalizado restándole el primer carácter del abecedario: `int index = c - 'a'`. Usa comodidades nativas como `Character.isDigit()` para filtrar caracteres no permitidos rápidamente.

8️⃣ int (trucos frecuentes)
🔢 Dígitos
digit = n % 10
n = n / 10

🔢 Math
Math.max(a, b)
Math.min(a, b)
Math.abs(x)

---
💡 **Resumen de Sección (int)**
- **Patrón principal:** Manipulación de dígitos, Matemática con bases (potencias/absolutos), Evitar desbordamiento (Overflow).
- **Idea Clave:** Comprender el peso de la base 10: el módulo `% 10` desprende el último dígito, la división entera `/ 10` remueve dicho último dígito.
- **Cómo resolverlo con Java:** Usa bucles iterativos `while (n > 0)` procesando porciones de a divisores. Para números muy enormes que pasen el límite de `Integer.MAX_VALUE` castéalos o defínelos preventivamente como `long`.

🔁 Patrones que se REPITEN (memorizá esto)
Patrón	Estructuras
Two Sum	HashMap
Frecuencias	HashMap
Duplicados	HashSet
Anagramas	HashMap + ArrayList
Ciclos	HashSet
Sliding Window	Array + pointers
DFS/BFS	Matriz + Set
Backtracking	ArrayList


PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());
req.entrySet()


usar parentesis en los ELSE - CASO DE PROBLEMA DE PARENTEISS


🔴 Problema 3: Comparar String con char

Intentaste:

if (word == '+')


📌 Problemas:

word es String

'+' es char

tipos incompatibles

🔴 Problema 4: Uso incorrecto de == con String

Intentaste usar == para comparar texto.

📌 Error clásico en Java:

== compara referencias

.equals() compara contenido

if (token.equals('+')) {  // ❌ ERROR
❌ Error de compilación, porque:

token.equals(...) espera un Object / String

'+' es un char

Java no convierte automáticamente char → String

✅ Forma correcta (la que usaste)
java
Copy code
if (token.equals("+")) {

            stack.push(Integer.parseInt(word)); PARSE INT SIEMPRE MINISUCULAR NO ParseInt

Evaluate Reverse Polish Notation
el orden
Integer b = stack.pop();
Integer a = stack.pop();
comparacion de sctirng con equals compara contenido 
== refrencia a memoria
if  ( word.equals("+") || word.equals("-") || word.equals("*") || word.equals("/") ){

"" commilla doble porque estoy comarando string que viene en un array de string de string