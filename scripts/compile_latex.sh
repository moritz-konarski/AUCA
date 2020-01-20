for file in $1; do 
    latexmk -pdf "$file"
done
