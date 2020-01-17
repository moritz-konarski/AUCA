cmake_minimum_required(VERSION "2.8.0")

project("01-lab")

add_definitions("std=c++11")

include(build/conanbuildinfo.cmake)
conan_basic_setup()

add_executable(01-lab 01-lab.cpp)
target_link_libraries(01-lab ${CONAN_LIBS})
