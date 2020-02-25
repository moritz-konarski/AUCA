#!/bin/bash

pandoc 03_source_notes.md -o _03_source_notes.pdf -V papersize=a4 -V linkcolor=blue -V geometry:margin=1in -V fontsize=12pt -V numbersections=true --toc 
