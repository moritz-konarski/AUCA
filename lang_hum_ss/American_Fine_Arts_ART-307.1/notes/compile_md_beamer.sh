#!/bin/bash

pandoc "$1" -o "$(basename "$1" .md)-beamer.pdf" -t beamer