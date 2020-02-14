#!/bin/bash

pandoc 03_bibliography.md -o 13_bibliography.pdf -V papersize=a4 -V linkcolor=blue -V geometry:margin=1in -V fontsize=12pt -V numbersections=true --toc 
