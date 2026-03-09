# Resumen de Semana 3: Stacks y Queues (Pilas y Colas)

## 📌 Estructuras y Patrones

### 1️⃣ Stack (`Deque<T>`)
- **Patrón principal:** Procesamiento `LIFO` (Último Último Entrar, Primero Salir), Paréntesis, Reverse Polish Notation.
- **Idea Clave:** Mantienes acceso solo al elemento de la cima del "plato". Vital al requerir retroceder cálculos.
- **Cómo resolverlo con Java:** Evita la clase legada `Stack<E>` (es pesada y sincronizada). A día de hoy, usa su interfaz moderna rápida: `Deque<E> stack = new ArrayDeque<>();`. Y maneja los métodos `.push()`, `.pop()` y `.peek()`.

### 2️⃣ Parsing y Mates (Evaluar RPN)
- **Patrón principal:** Ejecución de operadores sobre secuencias de texto.
- **Idea Clave:** Usas un Stack dinámico para apilar números. Cuando un texto resulta ser una operación ("+", "-", "*", "/"), desapilas los 2 últimos números guardados y guardas el nuevo resultado apilado.
- **Cómo resolverlo con Java:** Con un bucle que analice los tokens string de un `String[]`.

---

## ⚠️ Errores Comunes a Evitar

1. **Orden de extracción del Stack (`LIFO`)**:
   - ❌ En "Reverse Polish Notation" u otro similar evaluar: `Integer a = stack.pop(); Integer b = stack.pop(); return a - b;`. (Estarás invirtiendo los operandos si la operación es no conmutativa `[a/b, a-b]`).
   - ✅ Hazlo correctamente extrayendo el 2do, y luego el 1ero: `int b = stack.pop(); int a = stack.pop(); int result = a - b;`

2. **Parsing Integers Mal Escrito**:
   - ❌ `Integer.ParseInt("2")`
   - ✅ `Integer.parseInt("2")` (La `p` va en minúscula porque es un cammelCase).

3. **Comparador Lógico Extenso en Ifs**:
   - ❌ No poner los bloques de comparación limpios o mezclar paréntesis lógicos en el caso iterativo `if (word == "+")`.
   - ✅ Usa comillas dobles y el método `equals`: `if (word.equals("+") || word.equals("-") ...)`

4. **Llaves o Paréntesis Desapilados (Valid Parenthesis)**:
   - ❌ Olvidarte el "else" block, o que tu stack crashee porque se llame `.pop()` en un momento que estaba vacío.
   - ✅ Usar el método seguro `.isEmpty()` antes para asegurarte la continuidad.
