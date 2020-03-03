#!/bin/bash

mkdir "./$1"
touch "./$1/$1.s" "./$1/compile.sh"

echo ".section .data

.section .text
.global main
main:
    " > "./$1/$1.s"

echo "gcc $1.s -g -o a.out" > "./$1/compile.sh"
