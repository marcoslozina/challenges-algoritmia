# Resumen de Semana 3: Stacks y Queues (Pilas y Colas)

## 📌 Estructuras y Patrones

### 1️⃣ Stack (`Deque<T>`)
- **Patrón principal:** Procesamiento Último en Entrar, Primero en Salir (LIFO), Paréntesis, Notación Polaca Inversa (RPN).
- **Idea Clave:** Mantienes acceso solo al elemento de la cima del "plato". Vital al requerir retroceder cálculos.
- **Cómo resolverlo con Java:** Evita la clase legada `Stack<E>` (es pesada y sincronizada). A día de hoy, usa su interfaz moderna rápida: `Deque<E> stack = new ArrayDeque<>();`. Y maneja los métodos `.push()`, `.pop()` y `.peek()`.
- **⚠️ Errores Comunes:**
  - **Llaves o Paréntesis Desapilados (Valid Parenthesis)**: ❌ Olvidarte el "else" block, o que tu stack crashee porque se llame `.pop()` en un momento que estaba vacío. ✅ Usar el método seguro `.isEmpty()` antes para asegurarte la continuidad.

### 2️⃣ Parsing y Mates (Evaluar Notación Polaca Inversa - RPN)
- **Patrón principal:** Ejecución de operadores sobre secuencias de texto.
- **Idea Clave:** Usas un Stack dinámico para apilar números. Cuando un texto resulta ser una operación ("+", "-", "*", "/"), desapilas los 2 últimos números guardados y guardas el nuevo resultado apilado.
- **Cómo resolverlo con Java:** Con un bucle que analice los tokens string de un `String[]`.
- **⚠️ Errores Comunes:**
  - **Orden de extracción del Stack (Último en Entrar, Primero en Salir - LIFO)**: ❌ En RPN evaluar: `Integer a = stack.pop(); Integer b = stack.pop(); return a - b;`. (Estarás invirtiendo los operandos si la operación es no conmutativa `[a/b, a-b]`). ✅ Hazlo extrayendo el 2do, y luego el 1ero: `int b = stack.pop(); int a = stack.pop(); int result = a - b;`
  - **Parsing Integers Mal Escrito**: ❌ `Integer.ParseInt("2")`. ✅ `Integer.parseInt("2")` (La `p` va en minúscula porque es un cammelCase).
  - **Comparador Lógico Extenso en Ifs**: ❌ No poner los bloques limpios o mezclar paréntesis iterando `if (word == "+")`. ✅ Usa comillas dobles y `.equals`: `if (word.equals("+") || word.equals("-") ...)`.
