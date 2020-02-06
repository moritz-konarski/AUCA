#!/bin/bash

cd "./$1/build/"
rm -rf *
cmake ..
make
cd ../..
