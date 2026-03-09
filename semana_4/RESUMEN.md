# Resumen de Semana 4: Recursive DFS y Árboles

## 📌 Estructuras y Patrones

### 1️⃣ Depth-First Search (DFS) Recursivo
- **Patrón principal:** Búsqueda y análisis sobre Nodos en Árboles Binarios, Invertir Árboles, Calcular Profundidades Máximas, Encontrar Ancestros Comunes.
- **Idea Clave:** Confía en que la llamada recursiva (hacia los hijos de izquierda a derecha) te traerá la información que le pidas. Trata de resolver el subproblema actual y pasar el resultado hacia `root`.
- **Cómo resolverlo con Java:** Construyes una función `dfs(TreeNode node)`. Su paso fundamental es manejar el NULO: `if (node == null) return ...;`. Y posteriormente llamas a `dfs(node.left)` y `dfs(node.right)`.
- **⚠️ Errores Comunes:**
  - **Olvidar el Caso Base (`Base Case`)**: ❌ En Stack Overflow casi el 100% ocurre porque mandaste `dfs(node.left)` pero `node` era nulo. ✅ Coloca al inicio: `if (node == null) return 0;` (o respuesta nula).
  - **Perder el Retorno (Missing Return)**: ❌ Haces la llamada recursiva pero olvidas `retornar` lo que calculó la capa hija. ✅ Asegura devolver siempre: `return Math.max(leftResp, rightResp);`.
  - **Confundir Post-order, Pre-order e In-order**: ❌ Calcular lógicas anticipadamente sin esperar la respuesta de profundidad. ✅ Utiliza el **Post-order** (evaluar *luego* de visitar ambosijos) para comparaciones del padre hacia arriba.

### 2️⃣ Backtracking (ArrayLists y Combinatoria)
- **Patrón principal:** Exploración Exhaustiva, Subconjuntos, Permutaciones.
- **Idea Clave:** Construir posibles soluciones elemento a elemento en una Estructura de Lista, y descartarlas al fallar en cumplir condiciones.
- **Cómo resolverlo con Java:** Construyes con `list.add(val)` y deshaces tu modificación con `list.remove(list.size() - 1)` tras regresar de la llamada de función para que la lista limpia quede reutilizable para la otra rama.
- **⚠️ Errores Comunes:**
  - **Compartir Preferencia del Objeto Modificable**: ❌ Si agregas tu ArrayList temporal al resultado global con `res.add(list)`, al seguir mutando vaciarás todas las respuestas viejas por referencia de memoria en Java. ✅ Crea una copia o clon exacto con `res.add(new ArrayList<>(list));`.
