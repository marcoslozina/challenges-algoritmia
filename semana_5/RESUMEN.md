# Resumen de Semana 5: Sliding Window y Ordenamiento Avanzado

## 📌 Estructuras y Patrones

### 1️⃣ Sliding Window (Punteros Dinámicos)
- **Patrón principal:** Encontrar subtramos contiguos óptimos, Cadenas más largas sin repetición.
- **Idea Clave:** Mantén todo el tiempo tu lógica girando sobre "¿Debo achicar o alargar mi ventana?". Mantienes variables `left` y `right`. Expandir (correr `right`) sirve para cubrir terreno y cumplir el objetivo, y Contraer (correr `left`) sirve para optimizar o solucionar reglas rotas.
- **Cómo resolverlo con Java:** Con un bucle `for` o `while(right < array.length)` y uno en el interior `while(no_sea_valido) { left++; }`.

### 2️⃣ Ordenamiento de Intervalos / Interval Merge
- **Patrón principal:** Arreglar rangos solapados, Inserciones Lineales.
- **Idea Clave:** Siempre debes ordenar la entrada antes basándote en un límite. Generalmente, por el valor numérico inicial (`intervals[i][0]`). Si ordenas, comparar solapamientos se vuelve un pase recto $O(N)$.
- **Cómo resolverlo con Java:** Ordenas Arrays Multidimensionales de esta forma (`Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])));`).

---

## ⚠️ Errores Comunes a Evitar

1. **Calculando Tamaños de Ventana Desfasados**:
   - ❌ Es un error súper habitual intentar medir todo con un `int result = right - left;` y quedarse con uno menos dependiendo la posición, etc.
   - ✅ Comprender la matemática detrás: Puntero derecho menos puntero izquierdo (ej: índices 4 y 2), y le sumas 1 si el cálculo debe ser "inclusivo" porque cuenta el propio rango en el que están (`result = right - left + 1`).

2. **Borrar Duplicados Antes en Sliding Windows con HasMap**:
   - ❌ Eliminar todo el registro del Counter map del elemento anterior: `map.remove(s.charAt(left))` en lugar de solo reducir contadores.
   - ✅ Únicamente borraste un elemento (un caracter), debes decrementar y si vale 0, sí usar un `.remove`. Si solo restas sin condicionar `map.put(key, count - 1)` puedes terminar con frecuencias negativas fantasma o un map ruidoso innecesariamente.

3. **Cuidado con los Índices y Modificaciones in-place en Java (`for`)**:
   - ❌ En los arreglos fijos de Java el Arrays.asList no permite cambiar la longitud de manera "cómoda".
   - ✅ En problemas Merge Intervals, es infinitamente mejor empujar intervalos ya validados a un `List<int[]> res = new ArrayList<>()`, y al final reconvertirlo como `res.toArray(new int[res.size()][])`.
