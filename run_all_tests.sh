#!/bin/bash

# Script para compilar y ejecutar todos los tests

echo "=== Compilando y ejecutando todos los tests ==="
echo ""

# Lista de archivos Java
files=(
    "2043_simple_bank_system.java"
    "3161_block_placement_queries.java"
    "3045_count_prefix_and_suffix_pairs_ii.java"
    "3071_minimum_operations_to_write_letter_y.java"
    "2768_number_of_black_blocks.java"
    "723_candy_crush.java"
    "84_largest_rectangle_in_histogram.java"
    "2672_number_of_adjacent_elements_with_same_color.java"
    "3034_number_of_subarrays_that_match_pattern_i.java"
    "1861_rotating_the_box.java"
    "71_simplify_path.java"
    "56_merge_intervals.java"
    "146_lru_cache.java"
    "54_spiral_matrix.java"
    "68_text_justification.java"
    "332_reconstruct_itinerary.java"
)

# Compilar y ejecutar cada archivo
for file in "${files[@]}"; do
    echo "--- Procesando $file ---"
    
    # Compilar
    javac "$file" 2>&1
    if [ $? -eq 0 ]; then
        # Ejecutar (obtener nombre de clase sin extensión)
        classname=$(basename "$file" .java)
        java "$classname" 2>&1
        echo ""
    else
        echo "Error al compilar $file"
        echo ""
    fi
done

echo "=== Todos los tests completados ==="

