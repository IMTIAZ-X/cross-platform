cmake_minimum_required(VERSION 3.10)
project(WebApp C) # Specify C language for the project

set(CMAKE_C_STANDARD 99)

add_executable(WebApp main.c) # Define the WebApp target first

# Pass -sUSE_SDL=2 as a linker option. This is the primary way
# Emscripten enables SDL support, which correctly configures
# headers and libraries internally for compilation and linking.
target_link_options(WebApp PRIVATE "-sUSE_SDL=2")

# If you need to preload assets (like "--preload-file assets"), add it here
# target_link_options(WebApp PRIVATE "--preload-file assets")

# No need for target_compile_options or find_package(SDL2 REQUIRED) for Emscripten's SDL.
# The -sUSE_SDL=2 flag handles the SDL integration directly through emcc.
