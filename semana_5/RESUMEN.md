# Resumen de Semana 5: Sliding Window y Ordenamiento Avanzado

## 📌 Estructuras y Patrones

### 1️⃣ Sliding Window (Punteros Dinámicos)
- **Patrón principal:** Encontrar subtramos contiguos óptimos, Cadenas más largas sin repetición.
- **Idea Clave:** Mantén todo el tiempo tu lógica girando sobre "¿Debo achicar o alargar mi ventana?". Mantienes variables `left` y `right`. Expandir (correr `right`) sirve para cubrir terreno y cumplir el objetivo, y Contraer (correr `left`) sirve para optimizar o solucionar reglas rotas.
- **Cómo resolverlo con Java:** Con un bucle `for` o `while(right < array.length)` y uno en el interior `while(no_sea_valido) { left++; }`.
- **⚠️ Errores Comunes:**
  - **Calculando Tamaños de Ventana Desfasados**: ❌ Intentar medir todo con `int result = right - left;` perdiendo el valor de 1 lugar. ✅ Comprender el cálculo contiguo (inclusive): `result = right - left + 1`.
  - **Borrar Duplicados Antes en Maps**: ❌ Eliminar el registro entero de frecuencia de un caracter perdido: `map.remove(s.charAt(left))`. ✅ Únicamente debes restar `- 1` al contador, y usar `.remove` **SOLO si** valió 0.

### 2️⃣ Ordenamiento de Intervalos / Interval Merge
- **Patrón principal:** Arreglar rangos solapados, Inserciones Lineales.
- **Idea Clave:** Siempre debes ordenar la entrada antes basándote en un límite. Generalmente, por el valor numérico inicial (`intervals[i][0]`). Si ordenas, comparar solapamientos se vuelve un pase recto $O(N)$.
- **Cómo resolverlo con Java:** Ordenas Arrays Multidimensionales de esta forma (`Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])));`).
- **⚠️ Errores Comunes:**
  - **Cuidado con Modificaciones In-place Vectorizadas**: ❌ Intentar redimensionar `Arrays.asList` estáticos forzando longitud que Java rechaza. ✅ Empuja intervalos al `List<int[]> res = new ArrayList<>()` y termina retornando `res.toArray(new int[res.size()][])`.
