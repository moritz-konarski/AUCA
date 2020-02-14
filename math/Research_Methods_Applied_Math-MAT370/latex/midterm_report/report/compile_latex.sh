#!/bin/bash
cd ./latex_build
latexmk -pdf ../midterm_report
cd ..
mv ./latex_build/midterm_report.pdf .

