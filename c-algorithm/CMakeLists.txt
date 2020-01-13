cmake_minimum_required(VERSION 3.15)
project(c_algorithm C)

set(CMAKE_C_STANDARD 99)

add_library(c_algorithm library.c library.h quick_sort/quick_sort.c three_num.c)