cmake_minimum_required(VERSION 3.10)
project(Cross-Platform)

set(CMAKE_C_STANDARD 99)

# For Emscripten
if(EMSCRIPTEN)
    set(CMAKE_EXECUTABLE_SUFFIX ".html")
endif()

find_package(SDL2 REQUIRED)
include_directories(${SDL2_INCLUDE_DIRS})

add_executable(hello main.c)
target_link_libraries(hello ${SDL2_LIBRARIES})
