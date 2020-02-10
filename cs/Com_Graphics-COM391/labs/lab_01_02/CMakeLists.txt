
project("lab_01_02")

cmake_minimum_required(VERSION "2.8.0")

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

include(FindPkgConfig)

pkg_search_module(SDL2 REQUIRED sdl2)
pkg_search_module(GL REQUIRED gl)
pkg_search_module(GLEW REQUIRED glew)

include_directories(${SDL2_INCLUDE_DIRS} ${GL_INCLUDE_DIRS} ${GLEW_INCLUDE_DIRS})

add_executable(lab_01_02 lab_01_02.cpp)
target_link_libraries(lab_01_02 ${SDL2_LIBRARIES} ${GL_LIBRARIES} ${GLEW_LIBRARIES})

