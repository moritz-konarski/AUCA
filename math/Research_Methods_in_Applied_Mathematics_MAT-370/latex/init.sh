#!/bin/bash

mkdir "$1"
mkdir "$1/build"
touch "./$1/$1.tex" "./$1/compile_latex.sh"

echo "#!/bin/bash
cd "./build"
latexmk -pdf "../$1"
cd ..
mv "./build/$(basename "$1" .tex).pdf" "."
" > "./$1/compile_latex.sh"
