# Resumen de Semana 4: Recursive DFS y Árboles

## 📌 Estructuras y Patrones

### 1️⃣ Depth-First Search (DFS) Recursivo
- **Patrón principal:** Búsqueda y análisis sobre Nodos en Árboles Binarios, Invertir Árboles, Calcular Profundidades Máximas, Encontrar Ancestros Comunes.
- **Idea Clave:** Confía en que la llamada recursiva (hacia los hijos de izquierda a derecha) te traerá la información que le pidas. Trata de resolver el subproblema actual y pasar el resultado hacia `root`.
- **Cómo resolverlo con Java:** Construyes una función `dfs(TreeNode node)`. Su paso fundamental es manejar el NULO: `if (node == null) return ...;`. Y posteriormente llamas a `dfs(node.left)` y `dfs(node.right)`.

### 2️⃣ Backtracking (ArrayLists y Combinatoria)
- **Patrón principal:** Exploración Exhaustiva, Subconjuntos, Permutaciones.
- **Idea Clave:** Construir posibles soluciones elemento a elemento en una Estructura de Lista, y descartarlas al fallar en cumplir condiciones.
- **Cómo resolverlo con Java:** Construyes con `list.add(val)` y deshaces tu modificación con `list.remove(list.size() - 1)` tras regresar de la llamada de función para que la lista limpia quede reutilizable para la otra rama.

---

## ⚠️ Errores Comunes a Evitar

1. **Olvidar el Caso Base (`Base Case`)**:
   - ❌ En Stack Overflow casi el 100% de las veces esto pasa porque llamas recursivamente `dfs(node.left)` pero `node` puede venir en estado `Null`. Explotaría un `NullPointerException`.
   - ✅ Siempre coloca al inicio el guardia anti nulos: `if (node == null) return 0;` (o la respuesta vacía de objeto).

2. **Perder el Retorno (Missing Return)**:
   - ❌ Realizar el llamado de la función, pero no atrapar o `retornar` la burbuja que la ejecución hija generó.
   - ✅ En problemas Top-Down (donde se busca devolver), asegura devolver siempre calculando un máximo / booleano por cada capa: `return Math.max(leftResp, rightResp);`.

3. **Confundir Post-order, Pre-order e In-order**:
   - ❌ Visitar el nodo, sin querer modificarlo permanentemente o evaluarlo tempranamente para algoritmos como Maximum Depth.
   - ✅ El **Post-order** (visitar hijos izquierdos, hijos derechos y *luego* evaluar el padre) resulta vital para cuando dependas de la suma o comparación de respuestas completadas.
