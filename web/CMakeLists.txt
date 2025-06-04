cmake_minimum_required(VERSION 3.10)
project(WebApp)

set(CMAKE_C_STANDARD 99)

add_executable(WebApp main.c)

set_target_properties(WebApp PROPERTIES LINK_FLAGS "--preload-file assets")
