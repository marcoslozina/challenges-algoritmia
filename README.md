<div align="center">

# 🧠 LeetCode — Top Interview Problems

**A curated collection of the most frequently asked algorithm problems in technical interviews.**
Solved in Java, organized by topic, with patterns, complexity analysis, and full test coverage.

---

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=for-the-badge&logo=leetcode&logoColor=black)
![Problems](https://img.shields.io/badge/Problems%20Solved-50-brightgreen?style=for-the-badge)
![Weeks](https://img.shields.io/badge/Study%20Plan-6%20Weeks-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)

[![Website](https://img.shields.io/badge/marcoslozina.com-000000?style=for-the-badge&logo=google-chrome&logoColor=white)](https://www.marcoslozina.com)
[![API](https://img.shields.io/badge/API-api.marcoslozina.com-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://api.marcoslozina.com)
[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://buymeacoffee.com/codefuel)
[![PayPal](https://img.shields.io/badge/Donate-PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://www.paypal.com/donate/?hosted_button_id=4TYGJ5S8CLX8J)

</div>

---

## ✨ About this repository

This is not a random collection of problems. Every problem here was **hand-picked** because it:

- Appears **repeatedly** in FAANG and top-tier tech company interviews
- Covers a **fundamental pattern** that can be applied to dozens of similar problems
- Builds on top of the previous week's concepts in a structured **6-week plan**

> **The goal:** Don't just memorize solutions. Understand the *pattern*, recognize it fast, and apply it under pressure.

---

## 📁 Structure

```
challenges-algoritmia/
├── semana_1/               # Week 1 — Arrays & Strings (Basics)
├── semana_2/               # Week 2 — HashMaps & Sets
├── semana_3/               # Week 3 — Stacks & Queues
├── semana_4/               # Week 4 — Trees & Recursion
├── semana_5/               # Week 5 — Sorting & Sliding Window
├── semana_6/               # Week 6 — Dynamic Programming (Basic)
└── problemas_adicionales/  # Bonus — Advanced & Mixed Problems
```

Each file includes:
- Problem description (English)
- Solution approach explanation
- Time and space complexity (Big O)
- Unit tests in the `main` method using Java assertions

---

## 📊 Progress

| Week | Topic | Problems | Status |
|------|-------|----------|--------|
| 1 | Arrays & Strings | 8 | ✅ Complete |
| 2 | HashMaps & Sets | 7 | ✅ Complete |
| 3 | Stacks & Queues | 5 | ✅ Complete |
| 4 | Trees & Recursion | 5 | ✅ Complete |
| 5 | Sorting & Sliding Window | 5 | ✅ Complete |
| 6 | Dynamic Programming | 5 | ✅ Complete |
| + | Additional & Advanced | 15 | ✅ Complete |
| | **Total** | **50** | **✅ 50/50** |

---

## 📚 Problems by Week

### Week 1 — Arrays & Strings
> **Goal:** Master array manipulation, string operations, and introduce HashSet/Two Pointers.

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 217 | [Contains Duplicate](semana_1/217_contains_duplicate.java) | HashSet | 🟢 Easy |
| 344 | [Reverse String](semana_1/344_reverse_string.java) | Two Pointers | 🟢 Easy |
| 1 | [Two Sum](semana_1/1_two_sum.java) | HashMap | 🟢 Easy |
| 242 | [Valid Anagram](semana_1/242_valid_anagram.java) | Char Array / HashMap | 🟢 Easy |
| — | [Binary Search — Even Numbers](semana_1/binary_search_numeros_pares.java) | Binary Search | 🟢 Easy |
| — | [First Duplicate Character](semana_1/detectar_primer_caracter_duplicado.java) | HashSet | 🟢 Easy |
| 125 | [Valid Palindrome](semana_1/125_valid_palindrome.java) | Two Pointers | 🟢 Easy |
| 20 | [Valid Parentheses](semana_1/20_valid_parentheses.java) | Stack | 🟢 Easy |

### Week 2 — HashMaps & Sets
> **Goal:** Deepen understanding of key structures for O(1) lookups, counting, and relationship mapping.

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 49 | [Group Anagrams](semana_2/49_group_anagrams.java) | HashMap + Sort | 🟡 Medium |
| 347 | [Top K Frequent Elements](semana_2/347_top_k_frequent_elements.java) | HashMap + Heap | 🟡 Medium |
| 36 | [Valid Sudoku](semana_2/36_valid_sudoku.java) | Set Validation | 🟡 Medium |
| 202 | [Happy Number](semana_2/202_happy_number.java) | Cycle Detection | 🟢 Easy |
| 205 | [Isomorphic Strings](semana_2/205_isomorphic_strings.java) | Bi-mapping | 🟢 Easy |
| 128 | [Longest Consecutive Sequence](semana_2/128_longest_consecutive_sequence.java) | HashSet + Optimization | 🟡 Medium |
| 1636 | [Sort Array by Increasing Frequency](semana_2/1636_sort_array_by_increasing_frequency.java) | HashMap + Sort | 🟢 Easy |

### Week 3 — Stacks & Queues
> **Goal:** Understand LIFO/FIFO structures, monotonic stacks, and sequential access patterns.

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 155 | [Min Stack](semana_3/155_min_stack.java) | Stack with State | 🟡 Medium |
| 20 | [Valid Parentheses](semana_3/20_valid_parentheses.java) | Stack Parsing | 🟢 Easy |
| 739 | [Daily Temperatures](semana_3/739_daily_temperatures.java) | Monotonic Stack | 🟡 Medium |
| 232 | [Implement Queue using Stacks](semana_3/232_implement_queue_using_stacks.java) | Stack/Queue Simulation | 🟢 Easy |
| 150 | [Evaluate Reverse Polish Notation](semana_3/150_evaluate_reverse_polish_notation.java) | Stack Math | 🟡 Medium |

### Week 4 — Trees & Recursion
> **Goal:** Understand hierarchical structures, DFS traversals (pre/in/post-order), and recursive thinking.

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 104 | [Maximum Depth of Binary Tree](semana_4/104_maximum_depth_of_binary_tree.java) | Recursive DFS | 🟢 Easy |
| 226 | [Invert Binary Tree](semana_4/226_invert_binary_tree.java) | Recursion | 🟢 Easy |
| 543 | [Diameter of Binary Tree](semana_4/543_diameter_of_binary_tree.java) | DFS with State | 🟢 Easy |
| 236 | [Lowest Common Ancestor](semana_4/236_lowest_common_ancestor.java) | Recursion | 🟡 Medium |
| 101 | [Symmetric Tree](semana_4/101_symmetric_tree.java) | Recursion + Mirror | 🟢 Easy |

### Week 5 — Sorting & Sliding Window
> **Goal:** Apply variable and fixed sliding windows, interval merging, and sweep-line techniques.

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 56 | [Merge Intervals](problemas_adicionales/56_merge_intervals.java) | Sweep Line + Sort | 🟡 Medium |
| 57 | [Insert Interval](semana_5/57_insert_interval.java) | Sweep Line + Logic | 🟡 Medium |
| 239 | [Sliding Window Maximum](semana_5/239_sliding_window_maximum.java) | Monotonic Deque | 🔴 Hard |
| 3 | [Longest Substring Without Repeating Characters](semana_5/3_longest_substring_without_repeating_characters.java) | Sliding Window + Set | 🟡 Medium |
| 76 | [Minimum Window Substring](semana_5/76_minimum_window_substring.java) | Sliding Window + Map | 🔴 Hard |

### Week 6 — Dynamic Programming
> **Goal:** Introduction to subproblems, optimal substructure, memoization, and tabulation.

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 70 | [Climbing Stairs](semana_6/70_climbing_stairs.java) | Fibonacci DP | 🟢 Easy |
| 198 | [House Robber](semana_6/198_house_robber.java) | 1D Decision DP | 🟡 Medium |
| 322 | [Coin Change](semana_6/322_coin_change.java) | Unbounded Knapsack | 🟡 Medium |
| 5 | [Longest Palindromic Substring](semana_6/5_longest_palindromic_substring.java) | Expand Around Center | 🟡 Medium |
| 53 | [Maximum Subarray](semana_6/53_maximum_subarray.java) | Kadane's Algorithm | 🟡 Medium |

### Bonus — Additional & Advanced Problems

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 146 | [LRU Cache](problemas_adicionales/146_lru_cache.java) | HashMap + Doubly Linked List | 🟡 Medium |
| 84 | [Largest Rectangle in Histogram](problemas_adicionales/84_largest_rectangle_in_histogram.java) | Monotonic Stack | 🔴 Hard |
| 332 | [Reconstruct Itinerary](problemas_adicionales/332_reconstruct_itinerary.java) | Graph DFS (Hierholzer) | 🔴 Hard |
| 54 | [Spiral Matrix](problemas_adicionales/54_spiral_matrix.java) | Matrix Traversal | 🟡 Medium |
| 68 | [Text Justification](problemas_adicionales/68_text_justification.java) | String Formatting | 🔴 Hard |
| 71 | [Simplify Path](problemas_adicionales/71_simplify_path.java) | Stack Parsing | 🟡 Medium |
| 723 | [Candy Crush](problemas_adicionales/723_candy_crush.java) | Simulation + Gravity | 🟡 Medium |
| 3045 | [Count Prefix and Suffix Pairs II](problemas_adicionales/3045_count_prefix_and_suffix_pairs_ii.java) | Trie | 🔴 Hard |
| 3161 | [Block Placement Queries](problemas_adicionales/3161_block_placement_queries.java) | Binary Search | 🔴 Hard |
| 3071 | [Min Operations to Write Letter Y](problemas_adicionales/3071_minimum_operations_to_write_letter_y.java) | Grid Simulation | 🟡 Medium |
| 2768 | [Number of Black Blocks](problemas_adicionales/2768_number_of_black_blocks.java) | Counting | 🟡 Medium |
| 2672 | [Adjacent Elements Same Color](problemas_adicionales/2672_number_of_adjacent_elements_with_same_color.java) | Array Manipulation | 🟡 Medium |
| 3034 | [Subarrays Matching a Pattern I](problemas_adicionales/3034_number_of_subarrays_that_match_pattern_i.java) | Pattern Matching | 🟡 Medium |
| 1861 | [Rotating the Box](problemas_adicionales/1861_rotating_the_box.java) | Matrix + Two Pointers | 🟡 Medium |
| 2043 | [Simple Bank System](problemas_adicionales/2043_simple_bank_system.java) | System Design | 🟡 Medium |

---

## 🗺️ Algorithmic Patterns Playbook

The real skill in interviews is **pattern recognition** — seeing a new problem and knowing which tool to reach for. Here's the complete map:

### 1. Two Pointers
**When to use:** Array or string is sorted. Looking for pairs, in-place operations, or comparisons from both ends.
**Template:** `left = 0`, `right = n - 1`, loop while `left < right`.
> ⚠️ If the array isn't sorted, check if you can sort it first in O(N log N) without breaking the requirements.

- [1 - Two Sum](semana_1/1_two_sum.java) · [125 - Valid Palindrome](semana_1/125_valid_palindrome.java) · [344 - Reverse String](semana_1/344_reverse_string.java) · [1861 - Rotating the Box](problemas_adicionales/1861_rotating_the_box.java)

---

### 2. Fast & Slow Pointers (Cycle Detection)
**When to use:** Linked lists, sequences with cycles, finding the middle, or detecting infinite loops.
**Template:** `slow` moves 1 step, `fast` moves 2 steps. If they meet → cycle exists.
> ⚠️ Use Floyd's algorithm whenever a problem mentions "infinite", "cyclic repetitions", or "find the middle" in O(1) extra space.

- [202 - Happy Number](semana_2/202_happy_number.java)

---

### 3. Sliding Window
**When to use:** Longest/shortest substring, subarray, or desired value over a *contiguous* sequence.
**Template:** Expand with `right`. When condition breaks, shrink with `left`.
> ⚠️ Key question at each iteration: "Is my window valid? If not, move `left` until it is."

- [3 - Longest Substring Without Repeating Characters](semana_5/3_longest_substring_without_repeating_characters.java) · [76 - Minimum Window Substring](semana_5/76_minimum_window_substring.java) · [239 - Sliding Window Maximum](semana_5/239_sliding_window_maximum.java)

---

### 4. Merge Intervals (Sweep Line)
**When to use:** Mutually exclusive intervals, overlapping schedules, or merging ranges.
**Template:** Sort by start time. If `current.start <= previous.end` → overlap → merge.
> ⚠️ Always sort by start time. Merge by updating `end = Math.max(previous.end, current.end)`.

- [56 - Merge Intervals](problemas_adicionales/56_merge_intervals.java) · [57 - Insert Interval](semana_5/57_insert_interval.java)

---

### 5. Hashing & Frequency Counting
**When to use:** O(1) lookups, counting frequencies, detecting anagrams/duplicates, or mapping relationships.
**Template:** `HashMap<K, V>` for counting/mapping, `HashSet<T>` for presence/duplicates.
> ⚠️ For lowercase letters only, use `int[26]` instead of HashMap — it's significantly faster.

- [49 - Group Anagrams](semana_2/49_group_anagrams.java) · [242 - Valid Anagram](semana_1/242_valid_anagram.java) · [128 - Longest Consecutive Sequence](semana_2/128_longest_consecutive_sequence.java) · [36 - Valid Sudoku](semana_2/36_valid_sudoku.java) · [205 - Isomorphic Strings](semana_2/205_isomorphic_strings.java)

---

### 6. Modified Binary Search
**When to use:** Sorted (or rotated) input, requires O(log N).
**Template:** `mid = left + (right - left) / 2` — always use this to avoid integer overflow.
> ⚠️ Think carefully: should `while` be `<=` or `<`? Depends on whether you're finding an exact index or a boundary.

- [Binary Search - Even Numbers](semana_1/binary_search_numeros_pares.java) · [3161 - Block Placement Queries](problemas_adicionales/3161_block_placement_queries.java)

---

### 7. Tree DFS
**When to use:** Search tree nodes, find deepest path, check symmetric properties, evaluate bottom-up.
**Template:** `dfs(node)` recursive. Base case: `if (node == null) return ...`.
> ⚠️ Decide traversal order: Pre-order (process before children), In-order (between), Post-order (after). Post-order is critical when a parent needs computed results from its children first.

- [104 - Maximum Depth](semana_4/104_maximum_depth_of_binary_tree.java) · [226 - Invert Binary Tree](semana_4/226_invert_binary_tree.java) · [543 - Diameter](semana_4/543_diameter_of_binary_tree.java) · [236 - Lowest Common Ancestor](semana_4/236_lowest_common_ancestor.java) · [101 - Symmetric Tree](semana_4/101_symmetric_tree.java)

---

### 8. Stack & Monotonic Stack
**When to use:** 
- *Classic:* Parse nested structures (parentheses, paths) or LIFO order reversal.
- *Monotonic:* Find "next greater" or "next smaller" element efficiently.

**Template (Monotonic):** `while (!stack.isEmpty() && current > array[stack.peek()]) { stack.pop(); }`
> ⚠️ Use `Deque` / `ArrayDeque` in modern Java — the old `Stack` class is synchronized and slower. In monotonic stacks, store *indices*, not values.

- **Classic:** [20 - Valid Parentheses](semana_1/20_valid_parentheses.java) · [150 - Reverse Polish Notation](semana_3/150_evaluate_reverse_polish_notation.java) · [71 - Simplify Path](problemas_adicionales/71_simplify_path.java)
- **Monotonic:** [739 - Daily Temperatures](semana_3/739_daily_temperatures.java) · [84 - Largest Rectangle in Histogram](problemas_adicionales/84_largest_rectangle_in_histogram.java)
- **Architecture:** [155 - Min Stack](semana_3/155_min_stack.java) · [232 - Queue using Stacks](semana_3/232_implement_queue_using_stacks.java)

---

### 9. Top K Elements (Heaps)
**When to use:** Find top/smallest/most-frequent K elements.
**Template:** `PriorityQueue` of size K. If `pq.size() > K` → poll.
> ⚠️ For **K largest**: use a Min-Heap of size K. For **K smallest**: use a Max-Heap. You always evict the weakest from the root.

- [347 - Top K Frequent Elements](semana_2/347_top_k_frequent_elements.java)

---

### 10. Graph Traversal (DFS / BFS)
**When to use:** Networks, connections, finding paths between states, Eulerian paths.
**Template:** Adjacency list `Map<Node, List<Node>>` + `HashSet<Node>` for visited.
> ⚠️ **Shortest path** → BFS (Queue) is mandatory. **Full exploration or backtracking** → DFS (Recursive/Stack).

- [332 - Reconstruct Itinerary](problemas_adicionales/332_reconstruct_itinerary.java) *(Hierholzer's Algorithm)*

---

### 11. Dynamic Programming (1D & Strings)
**When to use:** Max/min/longest value, choices at each step, overlapping subproblems.
**Template:** Identify state variable → initialize `dp[]` → base cases → recurrence relation.
> ⚠️ Before coding: **draw the recursion tree by hand**. When you see the repetition visually, apply Memoization (Top-Down). Only convert to Tabulation if O(1) space is required.

- [70 - Climbing Stairs](semana_6/70_climbing_stairs.java) · [198 - House Robber](semana_6/198_house_robber.java) · [322 - Coin Change](semana_6/322_coin_change.java) · [53 - Maximum Subarray](semana_6/53_maximum_subarray.java) · [5 - Longest Palindromic Substring](semana_6/5_longest_palindromic_substring.java)

---

### 12. Trie & Advanced String Matching
**When to use:** Dictionary lookups, prefix validation, or substring mathematical matching.
**Template:** Inner `TrieNode` class with `TrieNode[26] children` and `boolean isEndOfWord`.
> ⚠️ A Trie shines when lookup complexity must depend only on O(L) (word length) — completely ignoring the size of the dictionary.

- [3045 - Count Prefix and Suffix Pairs II](problemas_adicionales/3045_count_prefix_and_suffix_pairs_ii.java) · [3034 - Subarrays Matching Pattern](problemas_adicionales/3034_number_of_subarrays_that_match_pattern_i.java) · [68 - Text Justification](problemas_adicionales/68_text_justification.java)

---

### 13. Matrix Traversal & Simulation
**When to use:** Navigate a 2D grid in a specific pattern, apply game logic (gravity, matches), rotate without extra space.
**Template:** Direction array: `int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}`.
> ⚠️ Always validate bounds in a separate check: `if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C)`. For gravity simulations, work column by column.

- [54 - Spiral Matrix](problemas_adicionales/54_spiral_matrix.java) · [723 - Candy Crush](problemas_adicionales/723_candy_crush.java) · [3071 - Min Operations Letter Y](problemas_adicionales/3071_minimum_operations_to_write_letter_y.java) · [2768 - Number of Black Blocks](problemas_adicionales/2768_number_of_black_blocks.java)

---

### 14. Design & Data Structures
**When to use:** Implement a class with specific combined data structure properties and O(1) constraints.
**Template:** Wrap fields as `private`. Use `HashMap` to pair keys to node pointers for O(1) manipulation.
> ⚠️ Golden rule: when you need **O(1) access + chronological or frequency-of-use control**, the answer is always `HashMap` + `Doubly Linked List`.

- [146 - LRU Cache](problemas_adicionales/146_lru_cache.java) · [2043 - Simple Bank System](problemas_adicionales/2043_simple_bank_system.java)

---

## 🚀 Running the Code

### Single problem

```bash
# Compile
javac semana_X/problem_name.java

# Run with assertions enabled
java -ea ClassName
```

Example:
```bash
cd semana_2
javac 49_group_anagrams.java
java -ea Solution
```

### Run all tests at once

```bash
./run_all_tests.sh
```

---

## 📋 Requirements

- Java JDK 8 or higher
- `javac` + `java` on your PATH

---

## 📝 Notes

- All solutions are optimized for the best possible Big O complexity
- Tests use Java `assert` — always run with `-ea` flag to enable assertions
- Problem descriptions are in English; tips and comments may include Spanish (Rioplatense)
- Patterns are inspired by [*Grokking the Coding Interview*](https://www.educative.io/courses/grokking-the-coding-interview)

---

---

## ☕ Support

Si este repo te fue útil para preparar entrevistas o aprender patrones, podés apoyar el trabajo:

<div align="center">

[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://buymeacoffee.com/codefuel)
[![PayPal](https://img.shields.io/badge/Donate-PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://www.paypal.com/donate/?hosted_button_id=4TYGJ5S8CLX8J)

</div>

- ⭐ Dale una estrella al repo si te resultó útil
- 🌐 Visitá [marcoslozina.com](https://www.marcoslozina.com) para más contenido
- 🔌 Explorá la [API](https://api.marcoslozina.com) con endpoints relacionados

---

<div align="center">

Made with ☕ and a lot of patience.

*Study the patterns. Not the solutions.*

</div>
