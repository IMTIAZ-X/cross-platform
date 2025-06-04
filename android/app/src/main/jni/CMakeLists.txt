cmake_minimum_required(VERSION 3.10)
project(AndroidApp)

add_library(main SHARED main.c)

find_library(log-lib log)
find_library(android-lib android)

target_link_libraries(main ${log-lib} ${android-lib} SDL2)
