cmake_minimum_required(VERSION 3.10)
project(WebApp C) # Specify C language for the project

set(CMAKE_C_STANDARD 99)

add_executable(WebApp main.c)

# Explicitly add Emscripten SDL linker option using target_link_options.
# This is the most direct way to pass linker flags to a target in modern CMake
# and should ensure Emscripten correctly enables its SDL port.
target_link_options(WebApp PRIVATE "-sUSE_SDL=2")

# If you have assets to preload, you can add this line back:
# target_link_options(WebApp PRIVATE "--preload-file assets")
# For now, I've commented it out to focus on the SDL issue.
