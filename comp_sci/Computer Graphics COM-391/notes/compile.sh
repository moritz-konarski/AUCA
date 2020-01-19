for file in $1; do 
    pandoc "$file" -o "$(basename "$file" .md).pdf" -V papersize=a4 -V linkcolor=blue -V geometry:margin=1in
done
