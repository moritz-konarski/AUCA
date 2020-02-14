project("lab_03_02")

cmake_minimum_required(VERSION "2.8.0")

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

set (CMAKE_CXX_STANDARD 17)

include(FindPkgConfig)
pkg_search_module(SDL2 REQUIRED sdl2)
pkg_search_module(GL REQUIRED gl)
pkg_search_module(GLEW REQUIRED glew)
pkg_search_module(GLM REQUIRED glm)

include_directories(${SDL2_INCLUDE_DIRS} ${GL_INCLUDE_DIRS} ${GLEW_INCLUDE_DIRS} ${GLM_INCLUDE_DIRS})

add_executable(lab_03_02 lab_03_02.cpp)
target_link_libraries(lab_03_02 ${SDL2_LIBRARIES} ${GL_LIBRARIES} ${GLEW_LIBRARIES} ${GLM_LIBRARIES})

