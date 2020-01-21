#!/bin/bash

cd ./build
latexmk -pdf ../project_01
cd ..
mv ./build/project_01.pdf .

