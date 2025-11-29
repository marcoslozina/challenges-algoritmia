#!/bin/bash

# Script to compile and run all tests

echo "=== Compiling and running all tests ==="
echo ""

# Find all Java files in week directories and additional problems
directories=("semana_2" "semana_3" "semana_4" "semana_5" "semana_6" "problemas_adicionales")

for dir in "${directories[@]}"; do
    if [ -d "$dir" ]; then
        echo "--- Processing directory: $dir ---"
        for file in "$dir"/*.java; do
            if [ -f "$file" ]; then
                echo "  Compiling: $file"
                javac "$file" 2>&1
                if [ $? -eq 0 ]; then
                    # Get class name from file
                    classname=$(basename "$file" .java)
                    # Extract class name (remove numbers and underscores, capitalize)
                    # For most files, the class is "Solution" or the problem name
                    cd "$dir"
                    java -ea "$classname" 2>&1
                    cd ..
                    echo ""
                else
                    echo "  Error compiling $file"
                    echo ""
                fi
            fi
        done
    fi
done

echo "=== All tests completed ==="
