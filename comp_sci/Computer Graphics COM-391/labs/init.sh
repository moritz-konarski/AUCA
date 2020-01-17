#!/bin/bash

# Creating directories and files

mkdir "./$1"
mkdir "./$1/build/"
touch "./$1/$1.cpp" "./$1/CMakeLists.txt" "./$1/conanfile.txt" "./$1/compile.sh" "./$1/rebuild.sh"

# Adding content to CMakeLists.txt

echo "
cmake_minimum_required(VERSION \"2.8.0\")

project(\"$1\")

add_definitions(\"-std=c++11\")
add_definitions(\"-G \"Visual Studio 16 2019\"\")
add_definitions(\"-A \"x64\"\")

include(\${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
conan_basic_setup()

add_executable("$1" "$1".cpp)
target_link_libraries("$1" \${CONAN_LIBS})
" > "./$1/CMakeLists.txt"

# Adding content to conanfile.txt

echo "
[requires]
sdl2/2.0.10@bincrafters/stable
glew/2.1.0@bincrafters/stable

[generators]
cmake
" > "./$1/conanfile.txt"

# Adding content to cpp source file

echo "
#include <GL/glew.h>
#include <SDL.h>
#include <SDL_opengl.h> 

int main(int argc, char **argv) {
    
    return 0;
}
" > "./$1/$1.cpp"

# Add content to compile file

echo "powershell.exe "cmake" "-S" "./$1/" "-B" "./$1/build/"" > "./$1/compile.sh"

# Add content to compile file

echo "powershell.exe "conan" "install" "./$1/" "-if" "./$1/build/" "--build" "glew" "-s" "build_type=Debug"" > "./$1/rebuild.sh"

# Initialize conan

powershell.exe "conan" "install" "./$1/" "-if" "./$1/build/" "--build" "glew" "-s" "build_type=Debug"
