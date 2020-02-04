#!/bin/bash

mkdir "./$1"
touch "./$1/$1.s"

echo ".section .data

.section .text
.global main
main:
    " > "./$1/$1.s"
