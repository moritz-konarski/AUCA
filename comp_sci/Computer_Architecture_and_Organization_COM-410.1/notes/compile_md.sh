#!/bin/bash

pandoc "$1" -o "$(basename "$1" .md).pdf" -V papersize=a4 -V linkcolor=blue -V geometry:margin=1in