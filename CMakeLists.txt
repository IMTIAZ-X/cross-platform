cmake_minimum_required(VERSION 3.10)
project(cross-platform)

set(CMAKE_C_STANDARD 99)

find_package(SDL2 REQUIRED)
include_directories(${SDL2_INCLUDE_DIRS})

add_executable(CrossPlatformApp main.c)
target_link_libraries(CrossPlatformApp ${SDL2_LIBRARIES})
