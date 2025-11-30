#!/bin/bash

# Script to compile and run all tests

echo "=== Compiling and running all tests ==="
echo ""

# Find all Java files in week directories and additional problems
directories=("semana_1" "semana_2" "semana_3" "semana_4" "semana_5" "semana_6" "problemas_adicionales")

total_tests=0
passed_tests=0
failed_tests=0

for dir in "${directories[@]}"; do
    if [ -d "$dir" ]; then
        echo "--- Processing directory: $dir ---"
        for file in "$dir"/*.java; do
            if [ -f "$file" ]; then
                filename=$(basename "$file")
                echo "  Compiling: $filename"
                
                # Compile
                javac "$file" 2>&1
                if [ $? -eq 0 ]; then
                    # Extract class name from file (look for "class ClassName")
                    # Most files use "Solution", but some use "Bank", "LRUCache", "MinStack", "MyQueue"
                    classname=$(grep -E "^class " "$file" | head -1 | sed 's/^class //' | sed 's/ .*$//')
                    
                    if [ -z "$classname" ]; then
                        # Fallback: try to get first class name
                        classname=$(grep -E "^public class |^class " "$file" | head -1 | sed 's/^public class //' | sed 's/^class //' | sed 's/ .*$//')
                    fi
                    
                    if [ -z "$classname" ]; then
                        echo "  ✗ $filename - Could not determine class name"
                        failed_tests=$((failed_tests + 1))
                        total_tests=$((total_tests + 1))
                        echo ""
                        continue
                    fi
                    
                    echo "    Running class: $classname"
                    
                    # Change to directory to run
                    cd "$dir"
                    
                    # Try to run with -ea for assertions
                    java -ea "$classname" > /tmp/test_output_$$.txt 2>&1
                    exit_code=$?
                    
                    if [ $exit_code -eq 0 ]; then
                        echo "  ✓ $filename - PASSED"
                        passed_tests=$((passed_tests + 1))
                    else
                        echo "  ✗ $filename - FAILED (exit code: $exit_code)"
                        # Show first few lines of error
                        head -3 /tmp/test_output_$$.txt 2>/dev/null | sed 's/^/    /'
                        failed_tests=$((failed_tests + 1))
                    fi
                    
                    cd ..
                    total_tests=$((total_tests + 1))
                else
                    echo "  ✗ $filename - COMPILATION ERROR"
                    failed_tests=$((failed_tests + 1))
                    total_tests=$((total_tests + 1))
                fi
                echo ""
            fi
        done
    fi
done

# Cleanup
rm -f /tmp/test_output_$$.txt

echo "=== Test Summary ==="
echo "Total tests: $total_tests"
echo "Passed: $passed_tests"
echo "Failed: $failed_tests"
echo ""

if [ $failed_tests -eq 0 ]; then
    echo "🎉 All tests passed!"
    exit 0
else
    echo "⚠️  Some tests failed"
    exit 1
fi
