# Challenges Algoritmia

This repository contains optimized Java solutions for LeetCode algorithm problems, organized according to a 6-week study plan.

## 📁 Directory Structure

```
challenges-algoritmia/
├── semana_1/          # Week 1: Arrays and Strings (basic)
├── semana_2/          # Week 2: HashMap and Sets
├── semana_3/          # Week 3: Stacks and Queues
├── semana_4/          # Week 4: Trees and Recursion
├── semana_5/          # Week 5: Sorting & Sliding Window
├── semana_6/          # Week 6: Dynamic Programming (Basic)
└── problemas_adicionales/  # Additional problems
```

Each problem file includes:
- Problem description (English)
- Solution approach explanation
- Time and space complexity (Big O)
- Unit tests in `main` method

## 📚 Index by Week

### ✅ Week 1: Arrays and Strings (Basic)
**Objective:** Get familiar with array manipulation, strings, and basic operations.

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| ContainsDuplicate | ✅ Completed | HashSet + Arrays | - |
| ReverseString | ✅ Completed | Two Pointers | - |
| TwoSum | ✅ Completed | HashMap + Search | - |
| ValidAnagram | ✅ Completed | HashMap / Char Array | - |
| BinarySearchNumerosPares | ✅ Completed | Binary Search | - |
| DetectarPrimerCaracterDuplicado | ✅ Completed | HashSet + Traversal | - |
| Palindromo | ✅ Completed | Two Pointers + Logic | - |
| ParentesisBalanceados | ✅ Completed | Stack | - |

### ✅ Week 2: HashMap and Sets
**Objective:** Deepen understanding of key structures for efficient searches and counting.

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| [49 - Group Anagrams](semana_2/49_group_anagrams.java) | ✅ Completed | HashMap with Lists | `semana_2/49_group_anagrams.java` |
| [347 - Top K Frequent Elements](semana_2/347_top_k_frequent_elements.java) | ✅ Completed | HashMap + PriorityQueue | `semana_2/347_top_k_frequent_elements.java` |
| [36 - Valid Sudoku](semana_2/36_valid_sudoku.java) | ✅ Completed | Set Validation | `semana_2/36_valid_sudoku.java` |
| [202 - Happy Number](semana_2/202_happy_number.java) | ✅ Completed | Cycle Detection with Set | `semana_2/202_happy_number.java` |
| [205 - Isomorphic Strings](semana_2/205_isomorphic_strings.java) | ✅ Completed | HashMap + Bi-mapping | `semana_2/205_isomorphic_strings.java` |
| [128 - Longest Consecutive Sequence](semana_2/128_longest_consecutive_sequence.java) | ✅ Completed | Set + Optimization | `semana_2/128_longest_consecutive_sequence.java` |

### ✅ Week 3: Stacks and Queues
**Objective:** Learn LIFO/FIFO structures for sequential problems.

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| [155 - Min Stack](semana_3/155_min_stack.java) | ✅ Completed | Stack with State | `semana_3/155_min_stack.java` |
| [20 - Valid Parentheses](semana_3/20_valid_parentheses.java) | ✅ Completed | Stack | `semana_3/20_valid_parentheses.java` |
| [739 - Daily Temperatures](semana_3/739_daily_temperatures.java) | ✅ Completed | Stack + Indices | `semana_3/739_daily_temperatures.java` |
| [232 - Implement Queue using Stacks](semana_3/232_implement_queue_using_stacks.java) | ✅ Completed | Stack/Queue Simulation | `semana_3/232_implement_queue_using_stacks.java` |
| [150 - Evaluate Reverse Polish Notation](semana_3/150_evaluate_reverse_polish_notation.java) | ✅ Completed | Stack Math | `semana_3/150_evaluate_reverse_polish_notation.java` |

### ✅ Week 4: Trees and Recursion
**Objective:** Understand hierarchical structures and recursion.

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| [104 - Maximum Depth of Binary Tree](semana_4/104_maximum_depth_of_binary_tree.java) | ✅ Completed | Recursive DFS | `semana_4/104_maximum_depth_of_binary_tree.java` |
| [226 - Invert Binary Tree](semana_4/226_invert_binary_tree.java) | ✅ Completed | Recursion | `semana_4/226_invert_binary_tree.java` |
| [543 - Diameter of Binary Tree](semana_4/543_diameter_of_binary_tree.java) | ✅ Completed | Recursion with State | `semana_4/543_diameter_of_binary_tree.java` |
| [236 - Lowest Common Ancestor](semana_4/236_lowest_common_ancestor.java) | ✅ Completed | Recursion | `semana_4/236_lowest_common_ancestor.java` |
| [101 - Symmetric Tree](semana_4/101_symmetric_tree.java) | ✅ Completed | Recursion + Mirror | `semana_4/101_symmetric_tree.java` |

### ✅ Week 5: Sorting & Sliding Window
**Objective:** Apply sliding windows and sorting techniques.

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| [56 - Merge Intervals](problemas_adicionales/56_merge_intervals.java) | ✅ Completed | Sorting | `problemas_adicionales/56_merge_intervals.java` |
| [57 - Insert Interval](semana_5/57_insert_interval.java) | ✅ Completed | Sorting + Logic | `semana_5/57_insert_interval.java` |
| [239 - Sliding Window Maximum](semana_5/239_sliding_window_maximum.java) | ✅ Completed | Deque + Window | `semana_5/239_sliding_window_maximum.java` |
| [3 - Longest Substring Without Repeating Characters](semana_5/3_longest_substring_without_repeating_characters.java) | ✅ Completed | Sliding Window + Set | `semana_5/3_longest_substring_without_repeating_characters.java` |
| [76 - Minimum Window Substring](semana_5/76_minimum_window_substring.java) | ✅ Completed | Sliding Window + Map | `semana_5/76_minimum_window_substring.java` |

### ✅ Week 6: Dynamic Programming (Basic)
**Objective:** Introduction to subproblems and memoization/tabulation.

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| [70 - Climbing Stairs](semana_6/70_climbing_stairs.java) | ✅ Completed | Basic DP (Fibonacci) | `semana_6/70_climbing_stairs.java` |
| [198 - House Robber](semana_6/198_house_robber.java) | ✅ Completed | 1D DP | `semana_6/198_house_robber.java` |
| [322 - Coin Change](semana_6/322_coin_change.java) | ✅ Completed | DP with Minimums | `semana_6/322_coin_change.java` |
| [5 - Longest Palindromic Substring](semana_6/5_longest_palindromic_substring.java) | ✅ Completed | DP + Strings | `semana_6/5_longest_palindromic_substring.java` |
| [53 - Maximum Subarray](semana_6/53_maximum_subarray.java) | ✅ Completed | Kadane's Algorithm | `semana_6/53_maximum_subarray.java` |

### 📦 Additional Problems

| Problem | Status | Topic | File |
|---------|--------|-------|------|
| [2043 - Simple Bank System](problemas_adicionales/2043_simple_bank_system.java) | ✅ Completed | System Design | `problemas_adicionales/2043_simple_bank_system.java` |
| [3161 - Block Placement Queries](problemas_adicionales/3161_block_placement_queries.java) | ✅ Completed | Binary Search | `problemas_adicionales/3161_block_placement_queries.java` |
| [3045 - Count Prefix and Suffix Pairs II](problemas_adicionales/3045_count_prefix_and_suffix_pairs_ii.java) | ✅ Completed | String Matching | `problemas_adicionales/3045_count_prefix_and_suffix_pairs_ii.java` |
| [3071 - Minimum Operations to Write the Letter Y](problemas_adicionales/3071_minimum_operations_to_write_letter_y.java) | ✅ Completed | Grid Manipulation | `problemas_adicionales/3071_minimum_operations_to_write_letter_y.java` |
| [2768 - Number of Black Blocks](problemas_adicionales/2768_number_of_black_blocks.java) | ✅ Completed | Counting | `problemas_adicionales/2768_number_of_black_blocks.java` |
| [723 - Candy Crush](problemas_adicionales/723_candy_crush.java) | ✅ Completed | Simulation | `problemas_adicionales/723_candy_crush.java` |
| [84 - Largest Rectangle in Histogram](problemas_adicionales/84_largest_rectangle_in_histogram.java) | ✅ Completed | Monotonic Stack | `problemas_adicionales/84_largest_rectangle_in_histogram.java` |
| [2672 - Number of Adjacent Elements With the Same Color](problemas_adicionales/2672_number_of_adjacent_elements_with_same_color.java) | ✅ Completed | Array Manipulation | `problemas_adicionales/2672_number_of_adjacent_elements_with_same_color.java` |
| [3034 - Number of Subarrays That Match a Pattern I](problemas_adicionales/3034_number_of_subarrays_that_match_pattern_i.java) | ✅ Completed | Pattern Matching | `problemas_adicionales/3034_number_of_subarrays_that_match_pattern_i.java` |
| [1861 - Rotating the Box](problemas_adicionales/1861_rotating_the_box.java) | ✅ Completed | Matrix Rotation | `problemas_adicionales/1861_rotating_the_box.java` |
| [71 - Simplify Path](problemas_adicionales/71_simplify_path.java) | ✅ Completed | Stack | `problemas_adicionales/71_simplify_path.java` |
| [146 - LRU Cache](problemas_adicionales/146_lru_cache.java) | ✅ Completed | Data Structure | `problemas_adicionales/146_lru_cache.java` |
| [54 - Spiral Matrix](problemas_adicionales/54_spiral_matrix.java) | ✅ Completed | Matrix Traversal | `problemas_adicionales/54_spiral_matrix.java` |
| [68 - Text Justification](problemas_adicionales/68_text_justification.java) | ✅ Completed | String Formatting | `problemas_adicionales/68_text_justification.java` |
| [332 - Reconstruct Itinerary](problemas_adicionales/332_reconstruct_itinerary.java) | ✅ Completed | Graph DFS | `problemas_adicionales/332_reconstruct_itinerary.java` |

**Total: 41 problems solved**

## 🚀 Execution

### Run a single problem

```bash
# Compile
javac semana_X/problem_name.java

# Run (with tests)
java -ea ProblemClass
```

Example:
```bash
cd semana_2
javac 49_group_anagrams.java
java -ea Solution
```

### Run all tests

```bash
./run_all_tests.sh
```

Or manually:
```bash
bash run_all_tests.sh
```

## 📋 Requirements

- Java JDK 8 or higher
- `javac` compiler
- `java` interpreter

## 📝 Notes

- All files include unit tests in the `main` method
- Solutions are optimized for the best Big O complexity
- Tests use `assert` - run with `java -ea ClassName` to enable assertions
- All problem descriptions are in English
- Problems are organized by week in separate directories
