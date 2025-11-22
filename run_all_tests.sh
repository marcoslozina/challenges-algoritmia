#!/bin/bash

# Script para compilar y ejecutar todos los tests

echo "=== Compilando y ejecutando todos los tests ==="
echo ""

# Lista de archivos Java
files=(
    # Problemas originales
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
    # Semana 2: HashMap y Sets
    "49_group_anagrams.java"
    "347_top_k_frequent_elements.java"
    "36_valid_sudoku.java"
    "202_happy_number.java"
    "205_isomorphic_strings.java"
    "128_longest_consecutive_sequence.java"
    # Semana 3: Pilas y Colas
    "155_min_stack.java"
    "20_valid_parentheses.java"
    "739_daily_temperatures.java"
    "232_implement_queue_using_stacks.java"
    "150_evaluate_reverse_polish_notation.java"
    # Semana 4: Árboles y Recursión
    "104_maximum_depth_of_binary_tree.java"
    "226_invert_binary_tree.java"
    "543_diameter_of_binary_tree.java"
    "236_lowest_common_ancestor.java"
    "101_symmetric_tree.java"
    # Semana 5: Sorting & Sliding Window
    "57_insert_interval.java"
    "239_sliding_window_maximum.java"
    "3_longest_substring_without_repeating_characters.java"
    "76_minimum_window_substring.java"
    # Semana 6: Programación Dinámica
    "70_climbing_stairs.java"
    "198_house_robber.java"
    "322_coin_change.java"
    "5_longest_palindromic_substring.java"
    "53_maximum_subarray.java"
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

