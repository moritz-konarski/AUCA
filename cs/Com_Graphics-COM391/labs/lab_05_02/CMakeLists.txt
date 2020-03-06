project("lab_05_02")

cmake_minimum_required(VERSION "2.8.0")

set(CMAKE_CXX_STANDARD 17)

include(FindPkgConfig)

pkg_search_module(SDL2 REQUIRED sdl2)
pkg_search_module(GL REQUIRED gl)
pkg_search_module(GLEW REQUIRED glew)
pkg_search_module(GLM REQUIRED glm)

include_directories(${SDL2_INCLUDE_DIRS} ${GL_INCLUDE_DIRS} ${GLEW_INCLUDE_DIRS} ${GLM_INCLUDE_DIRS})

include_directories("./include")

add_executable(lab_05_02
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
        lab_05_02.cpp
        )

target_link_libraries(lab_05_02 ${SDL2_LIBRARIES} ${GL_LIBRARIES} ${GLEW_LIBRARIES} ${GLM_LIBRARIES})

