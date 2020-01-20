for file in $1; do 
    pandoc "$file" -o "$(basename "$file" .md)-beamer.pdf" -t beamer
done
