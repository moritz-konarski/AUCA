#!/bin/bash

# Creating directories and files

mkdir "./$1"
mkdir "./$1/build/"
touch "./$1/$1.cpp" "./$1/CMakeLists.txt" #"./$1/compile.sh"

# Adding content to CMakeLists.txt

echo "
project(\"$1\")

cmake_minimum_required(VERSION \"2.8.0\")

set(CMAKE_CXX_FLAGS \"\${CMAKE_CXX_FLAGS} -std=c++11\")

set(CMAKE_CXX_STANDARD 17)

include(FindPkgConfig)

pkg_search_module(SDL2 REQUIRED sdl2)
pkg_search_module(GL REQUIRED gl)
pkg_search_module(GLEW REQUIRED glew)
pkg_search_module(GLM REQUIRED glm)

include_directories(\${SDL2_INCLUDE_DIRS} \${GL_INCLUDE_DIRS} \${GLEW_INCLUDE_DIRS} \${GLM_INCLUDE_DIRS})

add_executable(
    "$1" 
    include/scene/scene.hpp
    include/objects/object.hpp
    include/objects/camera.hpp
    include/objects/mesh.hpp
    include/geometries/vertex.hpp
    include/geometries/geometry.hpp
    include/geometries/es2_geometry.hpp
    include/geometries/geometry_generators.hpp
    include/materials/material.hpp
    include/materials/constant_material.hpp
    include/materials/es2_constant_material.hpp
    include/textures/texture.hpp
    include/textures/es2_texture.hpp
    include/renderer/renderer.hpp
    include/renderer/es2_renderer.hpp
    include/renderer/shader.hpp
    include/renderer/es2_shader.hpp
    include/window/window.hpp
    include/window/sdl_window.hpp
    include/utilities/utilities.hpp
    include/aur.hpp
    "$1".cpp
)

target_link_libraries("$1" \${SDL2_LIBRARIES} \${GL_LIBRARIES} \${GLEW_LIBRARIES} \${GLM_LIBRARIES})
" > "./$1/CMakeLists.txt"

# Adding content to cpp source file

echo "#include <GL/glew.h>
#include <SDL2/SDL.h>
#include <SDL2/SDL_opengl.h>
#include <glm/ext.hpp>

int main(int argc, char **argv) {

    static const int WIDTH = 500;
    static const int HEIGHT = 500;

    // Initialization
    SDL_Init(SDL_INIT_VIDEO);
    SDL_Window *window = SDL_CreateWindow(\"$1\", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, WIDTH, HEIGHT, SDL_WINDOW_OPENGL);
    SDL_GLContext gl_context = SDL_GL_CreateContext(window);
    glewExperimental = GL_TRUE;
    glewInit();
    SDL_GL_SetSwapInterval(1);
    
    // SDL Event Handling
    for (;;) {
        SDL_Event event;
		while (SDL_PollEvent(&event)) {
			if (event.type == SDL_QUIT) { goto end; }
		}
    }

end:
    // SDL Shutdown
    SDL_GL_DeleteContext(gl_context);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}
" > "./$1/$1.cpp"

# Call initial cmake

cd ./$1/build/
cmake ..
cd ../..
