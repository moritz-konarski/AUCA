for file in $1; do 
    cd build
    latexmk -pdf "../$file"
    cd ..
done
