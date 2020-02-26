#!/bin/bash

pandoc 05_outline.md -o _05_outline.pdf -V papersize=a4 -V linkcolor=blue -V geometry:margin=1in -V fontsize=12pt -V numbersections=true --toc 
